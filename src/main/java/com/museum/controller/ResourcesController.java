package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Log.MyLog;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.*;
import com.museum.service.IAccountService;
import com.museum.service.IReleasesService;
import com.museum.service.IResourceContentService;
import com.museum.service.IResourcesService;
import com.museum.util.FileUtil;
import com.museum.util.HttpContextUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-06-06
 */
@Api(tags = {"上传文件"})
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/release")
public class ResourcesController {
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

    @Resource
    private IReleasesService releasesService;

    @Resource
    private IResourceContentService resourceContentService;



    @ApiOperation(value = "上传文件")
    @PostMapping("/addfile")
    @MyLog(value = "发布资源上传文件")
    public Result savafile(@RequestBody MultipartFile file,String types,String title,String describes) throws IllegalStateException {
        int type=Integer.valueOf(types);
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
            Resources resources = new Resources();
            resources.setTimes(new Date());
            resources.setUid(acc.getId());
            resources.setReaddress(fileSave.getCanonicalPath());
            resources.setTypes(type);
            resources.setDescribes(describes);
            resources.setTitle(title);
            resources.setPathaddress(File);
            resources.setFilename(file.getOriginalFilename());
            resources.setFunctionId(1);
            resourcesService.add(resources);
            //存文件内容

            return   ResultUtil.success();

        }catch (Exception e){
            e.printStackTrace();
            return  ResultUtil.error(500,"上传失败");

        }
    }

    /*public   String readString2(String files) {
        String str = null;
        try {
        File file = new File(files);//定义一个file对象，用来初始化FileReader
        FileReader reader = null;//定义一个fileReader对象，用来初始化BufferedReader

            reader = new FileReader(file);

        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            System.out.println(s);
        }
        bReader.close();
        str = sb.toString();
        } catch (Exception e) {

        }
        return str;

    }*/

    @ApiOperation(value = "查询上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/getfile")
    public IPage<Resources> findListByPage(@RequestParam Integer page,
                                          @RequestParam Integer pageCount){
        return resourcesService.findListByPage(page, pageCount);
    }


/*    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return releasesService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Releases release){
        return releasesService.updateData(release);
    }



    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Releases findById(@PathVariable Long id){
        return releasesService.findById(id);
    }*/

    @ApiOperation(value = "下载文件")
    @GetMapping("{id}")
    @MyLog(value = "下载文件")
    public void findById(@PathVariable Long id, HttpServletResponse res,HttpServletRequest req){
        System.out.println(id);
        Resources re = resourcesService.findById(id);
        try {
            FileUtil.download(re.getReaddress(),res,re,req);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "查询图片")
    @GetMapping("/getpicture")
    public List<Releases> findById(){
        QueryWrapper queryWrappers  = new QueryWrapper();
        //queryWrapper.eq("phone",phone);
        queryWrappers.eq("types",1);
        return releasesService.list(queryWrappers);
    }

}
