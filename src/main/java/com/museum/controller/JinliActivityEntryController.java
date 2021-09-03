package com.museum.controller;

import com.museum.domain.Account;
import com.museum.domain.ActivityEntry;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import com.museum.util.page.PageList;
import com.museum.util.page.PageListUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IJinliActivityEntryService;
import com.museum.domain.JinliActivityEntry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 锦里公司活动录入 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Api(tags = {"锦里公司活动录入"})
@RestController
@RequestMapping("/jinli-activity-entry")
public class JinliActivityEntryController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IJinliActivityEntryService jinliActivityEntryService;

    @Resource
    private IAccountService accountService;

    //文件地址
    @Value("${File}")
    private String File;

    @ApiOperation(value = "新增锦里公司活动录入")
    @PostMapping()
    public int add(@RequestBody JinliActivityEntry jinliActivityEntry, HttpServletRequest req, MultipartFile file){
        String str= SystemDateUtils.getStrDate();
        Account ac=accountService.findAccount(req);
        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            java.io.File fileSave = new File(File, newVidoeName);
            FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
            jinliActivityEntry.setFileaddress(fileSave.getCanonicalPath());
            jinliActivityEntry.setFilename(file.getOriginalFilename());
            jinliActivityEntry.setCreatetime(str);
            jinliActivityEntry.setUid(ac.getId());

        }catch (Exception e){
            e.printStackTrace();

        }
        return jinliActivityEntryService.add(jinliActivityEntry);
    }

    @ApiOperation(value = "删除锦里公司活动录入")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return jinliActivityEntryService.delete(id);
    }

    @ApiOperation(value = "更新锦里公司活动录入")
    @PutMapping()
    public int update(@RequestBody JinliActivityEntry jinliActivityEntry){
        return jinliActivityEntryService.updateData(jinliActivityEntry);
    }

    @ApiOperation(value = "查询锦里公司活动录入分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public PageList<JinliActivityEntry> findListByPage(@RequestParam Integer page,
                                                  @RequestParam Integer pageCount){
        List<JinliActivityEntry> acc= new ArrayList();
        List<JinliActivityEntry> jae=jinliActivityEntryService.list();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (JinliActivityEntry a : jae){
            try {

                Date sd1=df.parse(df.format(new Date()));
                Date sd2=df.parse(a.getEndTime().toString());
                if(sd1.before(sd2)==true){
                    a.setState(2);
                }else {
                    a.setState(1);
                }
                acc.add(a);
            }catch (ParseException p){{
            }
            }
        }
        return PageListUtil.getPageList(acc.size(),page,acc,pageCount);
             }

 /*   @ApiOperation(value = "id查询锦里公司活动录入")
    @GetMapping("{id}")
    public JinliActivityEntry findById(@PathVariable Long id){
        return jinliActivityEntryService.findById(id);
    }
*/
}
