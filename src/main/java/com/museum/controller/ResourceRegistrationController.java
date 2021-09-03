package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.Resources;
import com.museum.service.IAccountService;
import com.museum.service.IResourcesService;
import com.museum.util.HttpContextUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-06-18
 */
@Api(tags = {"统一资源管理-----资源注册"})
@RestController
@RequestMapping("/resourceRegistration")
public class ResourceRegistrationController {

    /*    @Resource
    private SearchFileMapper searchFileMapper;*/
    //图片地址
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
    private IResourcesService resourcesService;

    @ApiOperation(value = "新增")
    @PostMapping()
    public Result add(@RequestBody MultipartFile file, int type, String title, String describes) throws IOException {
        String path=null;
        //获取文件后缀
        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
        // 重构文件名称
        String pikId = UUID.randomUUID().toString().replaceAll("-", "");
        String newVidoeName = pikId + "." + fileExt;
        //保存文件
        if(type==1){
            path=picture;
            File fileSave = new File(picture, newVidoeName);
        }
        if(type==2){
            path=Video;
            File fileSave = new File(Video, newVidoeName);
        }
        if(type==3){
            path=File;
            File fileSave = new File(File, newVidoeName);
        }
        File fileSave = new File(File, newVidoeName);
        FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String token=request.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        //获取用户名
        Account acc=accountService.getOne(queryWrapper);
        try {
            Resources re = new Resources();
            re.setFunctionId(2);
            re.setTitle(title);
            re.setDescribes(describes);
            re.setTimes(new Date());
            re.setShare(1);
            re.setUid(acc.getId());
            re.setTypes(type);
            re.setReaddress(fileSave.getCanonicalPath());
            re.setFilename(file.getOriginalFilename());
            re.setPathaddress(path);
            resourcesService.add(re);
            return  ResultUtil.success();
        }catch (IOException e){
            return ResultUtil.error(401,"上传失败");
        }


    }


    @ApiOperation(value = "查询共享的资源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/getfile")
    public IPage<Resources> findListByPage(@RequestParam Integer page,
                                           @RequestParam Integer pageCount,String filename,
                                           String username,String startTime,String endTime ){
        Account ac=null;
        QueryWrapper queryWrapper  = new QueryWrapper();
        if(filename!=null&&!"".equals(filename)){
            queryWrapper.like("filename",filename);
        }

        if(username!=null&&!"".equals(username)){
            QueryWrapper queryWrappers  = new QueryWrapper();
            queryWrappers.eq("userName",username);
            ac=accountService.getOne(queryWrappers);
            queryWrapper.eq("uid",ac.getId());
        }
            queryWrapper.eq("share",1);
        if(startTime!=null&&!"".equals(startTime)){
            queryWrapper.between("createDate",startTime,endTime);
        }
        return resourcesService.page(resourcesService.findListByPage(page, pageCount),queryWrapper);
    }


    @ApiOperation(value = "设置资源共享")
    @GetMapping("/getupdatefile")
    public void findListByPages(String id,HttpServletRequest req,String share ){
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrappers  = new QueryWrapper();
        queryWrappers.eq("userName",name);
        Account bo=accountService.getOne(queryWrappers);
        Resources re= new Resources();
        re.setId(Integer.valueOf(id));re.setShare(Integer.valueOf(share));
        re.setUid(bo.getId());
        resourcesService.updateById(re);

    }

    @ApiOperation(value = "查询自己的资源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/getuserfile")
    public IPage<Resources> findListByPages(@RequestParam Integer page,
                                            @RequestParam Integer pageCount,String filename,
                                            String startTime,String endTime,HttpServletRequest req ){

        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrappers  = new QueryWrapper();
        queryWrappers.eq("userName",name);
        Account bo=accountService.getOne(queryWrappers);

        QueryWrapper queryWrapper  = new QueryWrapper();
        if(filename!=null&&!"".equals(filename)){
            queryWrapper.like("filename",filename);
        }
        queryWrapper.like("uid",bo.getId());
        if(startTime!=null&&!"".equals(startTime)){
            queryWrapper.between("createDate",startTime,endTime);
        }
        return resourcesService.page(resourcesService.findListByPage(page, pageCount),queryWrapper);
    }


}
