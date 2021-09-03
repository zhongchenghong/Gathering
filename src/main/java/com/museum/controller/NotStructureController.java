package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.Resources;
import com.museum.service.IAccountService;
import com.museum.util.Download;
import com.museum.util.FileUtil;
import com.museum.util.HttpContextUtil;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.INotStructureService;
import com.museum.domain.NotStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 数据中心-非结构化数据 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Api(tags = {"数据中心-非结构化数据"})
@RestController
@RequestMapping("/not-structure")
public class NotStructureController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private INotStructureService notStructureService;

    //文件地址
    @Value("${File}")
    private String File;

    @Resource
    private IAccountService accountService;


    @ApiOperation(value = "新增数据中心-非结构化数据")
    @PostMapping("/add")
    public Result add(String name, String depment, String userName, String type, MultipartFile file, HttpServletRequest req){
        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            File fileSave = new File(File, newVidoeName);
            file.transferTo(fileSave);
            Account acc=accountService.findAccount(req);
            NotStructure notStructure = new NotStructure();
            notStructure.setCreatetimes(SystemDateUtils.getStrDate());
            notStructure.setUid(acc.getId());
            notStructure.setDepment(depment);
            notStructure.setName(name);
            notStructure.setUserName(userName);
            notStructure.setType(type);
            notStructure.setFileaddress(fileSave.getCanonicalPath());
            notStructure.setFilename(file.getOriginalFilename());
            //存文件内容
            notStructureService.add(notStructure);
            return   ResultUtil.success();

        }catch (Exception e){
            e.printStackTrace();
            return  ResultUtil.error(500,"上传失败");

        }
    }

    @ApiOperation(value = "删除数据中心-非结构化数据")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return notStructureService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-非结构化数据")
    @PutMapping("/update")
    public int update(@RequestBody NotStructure notStructure){
        return notStructureService.updateData(notStructure);
    }

    @ApiOperation(value = "查询数据中心-非结构化数据分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<NotStructure> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String name){
        QueryWrapper queryWrapper = new QueryWrapper();
        if(name!=null&&!"".equals(name)){
            queryWrapper.eq("num",name);
        }
        return notStructureService.page(notStructureService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询数据中心-非结构化数据")
    @GetMapping("{id}")
    public NotStructure findById(@PathVariable Long id){
        return notStructureService.findById(id);
    }

    @ApiOperation(value = "id查询数据中心-非结构化数据下载")
    @GetMapping("/getdown")
    public Result getdown(HttpServletResponse res,Long id,int types){
        NotStructure no=notStructureService.findById(id);
        Resources resour = new Resources();
        resour.setTypes(types);
        resour.setReaddress(no.getFileaddress());
        try {
            FileUtil.downloadpath(no.getFilename(),res,resour);
            return ResultUtil.success();
        }catch (IOException o){
            o.printStackTrace();
            return ResultUtil.error(401,"下载失败");
        }


    }


}
