package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.Resources;
import com.museum.service.IAccountService;
import com.museum.util.HttpContextUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ILectureService;
import com.museum.domain.Lecture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 数据中心-讲座数据管理 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Api(tags = {"数据中心-讲座数据管理"})
@RestController
@RequestMapping("/lecture")
public class LectureController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ILectureService lectureService;

    //文件地址
    @Value("${File}")
    private String File;

    @Resource
    private IAccountService accountService;


    @ApiOperation(value = "新增数据中心-讲座数据管理")
    @PostMapping("/add")
    public Result add(String name, String content, String username, HttpServletRequest req, MultipartFile file){
        Account acc=accountService.findAccount(req);
        Lecture lecture = new Lecture();
        lecture.setName(name);
        lecture.setContent(content);
        lecture.setUsername(username);
        lecture.setUid(acc.getId());
        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            java.io.File fileSave = new File(File, newVidoeName);
            file.transferTo(fileSave);
            lecture.setFileaddress(newVidoeName);
            lecture.setFilename(file.getOriginalFilename());
            //存文件内容
            lectureService.add(lecture);
            return ResultUtil.success();

        }catch (Exception e){
            e.printStackTrace();
            return  ResultUtil.error(500,"上传失败");

        }

    }

    @ApiOperation(value = "删除数据中心-讲座数据管理")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return lectureService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-讲座数据管理")
    @PutMapping()
    public int update(@RequestBody Lecture lecture){
        return lectureService.updateData(lecture);
    }

    @ApiOperation(value = "查询数据中心-讲座数据管理分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Lecture> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return lectureService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询数据中心-讲座数据管理")
    @GetMapping("{id}")
    public Lecture findById(@PathVariable Long id){
        return lectureService.findById(id);
    }

}
