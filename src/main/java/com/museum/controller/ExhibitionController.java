package com.museum.controller;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.domain.Account;
import com.museum.domain.ActivityEntryCountByYear;
import com.museum.service.IAccountService;
import com.museum.service.IExhibitionLinkageService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IExhibitionService;
import com.museum.domain.Exhibition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 陈列展览表单 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Api(tags = {"陈列展览表单"})
@RestController
@RequestMapping("/exhibition")
public class ExhibitionController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IExhibitionService exhibitionService;

    //文件地址
    @Value("${File}")
    private String File;

    @Resource
    private IAccountService accountService;


    @ApiOperation(value = "新增陈列展览表单")
    @PostMapping()
    public int add(
                   HttpServletRequest req,
                   @RequestParam("file") MultipartFile file,
                   @RequestParam("exhibitionType")String exhibitionType,
                   @RequestParam("startTime")String startTime,
                   @RequestParam("endTime")String endTime,
                   @RequestParam("exhibitionContent")String exhibitionContent,
                   @RequestParam("exhibitionTypeName")String exhibitionTypeName,
                   @RequestParam("peoplesum")int peoplesum,
                   @RequestParam("name")String name,
                   @RequestParam("exhibitionfathertype")int exhibitionfathertype,
                   @RequestParam("exhibitionfathertypename")String exhibitionfathertypename){

        Exhibition exhibition = new Exhibition();
        exhibition.setExhibitionType(exhibitionType);
        exhibition.setStartTime(startTime);
        exhibition.setEndTime(endTime);
        exhibition.setExhibitionContent(exhibitionContent);
        exhibition.setExhibitionTypeName(exhibitionTypeName);
        exhibition.setPeoplesum(peoplesum);
        exhibition.setName(name);
        exhibition.setExhibitionfathertype(exhibitionfathertype);
        exhibition.setExhibitionfathertypename(exhibitionfathertypename);

        String str= SystemDateUtils.getStrDate();
        Account ac=accountService.findAccount(req);
        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            File fileSave = new File(File, newVidoeName);
            FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
            exhibition.setFileaddress(fileSave.getCanonicalPath());
            exhibition.setFilename(file.getOriginalFilename());
            exhibition.setCreatetime(SystemDateUtils.getStrDate());


        }catch (Exception e){
            e.printStackTrace();

        }
        return exhibitionService.add(exhibition);
    }

    @ApiOperation(value = "删除陈列展览表单")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return exhibitionService.delete(id);
    }

    @ApiOperation(value = "更新陈列展览表单")
    @PutMapping()
    public int update(@RequestBody Exhibition exhibition){
        return exhibitionService.updateData(exhibition);
    }

    @ApiOperation(value = "查询陈列展览表单分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/findListByPage")
    public IPage<Exhibition> findListByPage(@RequestParam Integer page,
                                            @RequestParam Integer pageCount, String name,
                                            String exhibitionType,String startTime,String endTime){
        /* QueryWrapper queryWrapper  = new QueryWrapper();
        if(name!=null&&!"".equals(name)){
            queryWrapper.like("name",name);
        }

        if(exhibitionType!=null&&!"".equals(exhibitionType)){
            queryWrapper.eq("exhibitionType",exhibitionType);
        }
        if(startTime!=null&&!"".equals(startTime)){
            queryWrapper.between("createDate",startTime,endTime);
        }*/
        return exhibitionService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询陈列展览表单详情")
    @GetMapping("{id}")
    public Exhibition findById(@PathVariable Long id){
        return exhibitionService.findById(id);
    }

    @ApiOperation(value = "陈列展览按年统计")
    @GetMapping("/getCountByYear")
    public List<ActivityEntryCountByYear> getByYear(){
        return exhibitionService.getcountByYear();
    }


    @ApiOperation(value = "陈列次数统计")
    @GetMapping("/getCountBytype")
    public List<ActivityEntryCountByYear> getCountBytype(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return exhibitionService.getcountBytype(year+"");
    }



    @Resource
    private IExhibitionLinkageService exhibitionLinkageService;

}









