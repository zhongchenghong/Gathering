package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Log.MyLog;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.Resources;
import com.museum.service.IAccountService;
import com.museum.util.FileUtil;
import com.museum.util.HttpContextUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IAcademicPapersService;
import com.museum.domain.AcademicPapers;
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
 * 数据中心-学术论文 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Api(tags = {"数据中心-学术论文"})
@RestController
@RequestMapping("/academic-papers")
public class AcademicPapersController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAcademicPapersService academicPapersService;

    @Resource
    private IAccountService accountService;

    @Value("${File}")
    private String File;


    @ApiOperation(value = "新增数据中心-学术论文")
    @PostMapping("/add")
    public Result add(String title, String name, String introduce, String publishTime, MultipartFile file, HttpServletRequest req){
            Account ac=accountService.findAccount(req);
            AcademicPapers academicPapers = new  AcademicPapers();
            academicPapers.setTitle(title);
            academicPapers.setName(name);
            academicPapers.setTitle(title);
            academicPapers.setIntroduce(introduce);
            academicPapers.setPublishTime(publishTime);
            academicPapers.setUid(ac.getId());
        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            java.io.File fileSave = new File(File, newVidoeName);
            file.transferTo(fileSave);
            //获取用户名
            academicPapers.setFileaddress(fileSave.getCanonicalPath());
            academicPapers.setFilename(file.getOriginalFilename());
            academicPapersService.add(academicPapers);
            return   ResultUtil.success();

        }catch (Exception e){
            e.printStackTrace();
            return  ResultUtil.error(500,"上传失败");

        }

    }

    @ApiOperation(value = "删除数据中心-学术论文")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return academicPapersService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-学术论文")
    @PutMapping()
    public int update(@RequestBody AcademicPapers academicPapers){
        return academicPapersService.updateData(academicPapers);
    }

    @ApiOperation(value = "查询数据中心-学术论文分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<AcademicPapers> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String title){
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("title",title);
        return academicPapersService.page(academicPapersService.findListByPage(page, pageCount),queryWrappet);
    }

    @ApiOperation(value = "id查询数据中心-学术论文")
    @GetMapping("{id}")
    public AcademicPapers findById(@PathVariable Long id){
        return academicPapersService.findById(id);
    }

    @ApiOperation(value = "下载文件")
    @GetMapping("/down")
    @MyLog(value = "下载文件")
    public void down(@PathVariable Long id, HttpServletResponse res){
        System.out.println(id);
        AcademicPapers re = academicPapersService.findById(id);
        Resources ress = new Resources();
        ress.setPathaddress(re.getFileaddress());
        ress.setFilename(re.getFilename());
        try {
            FileUtil.downloadpath(re.getFilename(),res,ress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
