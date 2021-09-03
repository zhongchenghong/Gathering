package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Log.MyLog;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.PictureOVVoide;
import com.museum.domain.Resources;
import com.museum.service.IAccountService;
import com.museum.util.HttpContextUtil;
import com.museum.util.WangEditor;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IScreenResourcesService;
import com.museum.domain.ScreenResources;
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
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-06-29
 */
@Api(tags = {"统一发布------大屏资源上传"})
@RestController
@RequestMapping("/screen-resources")
public class ScreenResourcesController {

    @Value("${picture}")
    private String picture;
    //视视频地址
    @Value("${Video}")
    private String Video;
    //文件地址
    @Value("${File}")
    private String File;
    @Resource
    private IAccountService accountService;

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IScreenResourcesService screenResourcesService;



    @ApiOperation(value = "查询大屏上传的图片")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/getpictureResources")
    public IPage<ScreenResources> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("types",1);
        return screenResourcesService.page(screenResourcesService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "查询大屏上传的视频")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/getvideoResources")
    public IPage<ScreenResources> findListvideoByPage(@RequestParam Integer page,
                                                 @RequestParam Integer pageCount){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("types",2);
        return screenResourcesService.page(screenResourcesService.findListByPage(page, pageCount),queryWrapper);
    }


    /**
     *大屏视频图片上传
     * @param file
     * @param types
     * @return
     * @throws IllegalStateException
     *
     */
    @ApiOperation(value = "上传文件")
    @PostMapping("/addscreenfile")
    @MyLog(value = "大屏资源上传")
    public WangEditor savafile(@RequestBody MultipartFile file, String types) throws IllegalStateException {
        int type=Integer.valueOf(types);
        PictureOVVoide pv= new PictureOVVoide();
        File fileSave = null;
        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            if(type==1){
                fileSave = new File(picture, newVidoeName);
            }
            if(type==2){
                fileSave = new File(Video, newVidoeName);
            }
            if(type==3){
                fileSave = new File(File, newVidoeName);
            }
            FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
            HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
            String token=request.getHeader("token");
            String name= JWTUtil.getUsername(token);
            QueryWrapper queryWrapper  = new QueryWrapper();
            queryWrapper.eq("userName",name);
            //获取用户名
            Account acc=accountService.getOne(queryWrapper);
            ScreenResources resources = new ScreenResources();
            resources.setTimes(new Date());
            resources.setUid(acc.getId());
            resources.setReaddress(newVidoeName);
            resources.setTypes(type);
            resources.setPathaddress(File);
            resources.setFilename(file.getOriginalFilename());
            String url = fileSave.getCanonicalPath();
            pv.setUrl(newVidoeName);
            pv.setHref("");
            pv.setAlt("");
            WangEditor we = new WangEditor(pv);
            we.setErrno(0);
            screenResourcesService.add(resources);
            return we;

        }catch (Exception e){
            e.printStackTrace();
            pv.setUrl("");
            pv.setAlt("上传失败");
            pv.setHref("");
            return null;

        }}



}
