package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.museum.common.Log.MyLog;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.*;
import com.museum.service.IAccountService;
import com.museum.service.IDepartmentService;
import com.museum.service.IScreenResourcesService;
import com.museum.service.IScreenService;
import com.museum.util.HttpContextUtil;
import com.museum.util.WangEditor;
import com.museum.util.page.PageList;
import com.museum.util.page.PageListUtil;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-06-29
 */
@Api(tags = {"数据中心-多媒体发布"})
@RestController
@RequestMapping("/screen-resources-data")
public class ScreenResourcesDataController {

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

    @Resource
    private IScreenService screenService;

    @Resource
    private IDepartmentService departmentService;



    @ApiOperation(value = "多媒体发布数据库")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/getpictureResources")
    public PageList<ScreenResourcesData> findListByPage(@RequestParam Integer page,
                                                            @RequestParam Integer pageCount,String name){
        List<Screen> ac=screenService.list();
        List<ScreenResourcesData> sr = new ArrayList<ScreenResourcesData>();
        for (int i=0;i<ac.size();i++){
            if(ac.size()>0){
            ScreenResources  as= screenResourcesService.findById(Long.valueOf(ac.get(i).getScreenContentid()));
            ScreenResourcesData ad= new ScreenResourcesData();
            if(name==null||"".equals(name)){
                ad.setDepartment(departmentService.findById(Long.valueOf(accountService.getById(as.getUid()).getDepartmentId())).getDepartmentName());
                ad.setFilename(as.getFilename());
                ad.setTimes(as.getTimes());
                sr.set(i,ad);
            }else {
                if(name.equals(departmentService.findById(Long.valueOf(accountService.getById(as.getUid()).getDepartmentId())).getDepartmentName())){
                    ad.setDepartment(departmentService.findById(Long.valueOf(accountService.getById(as.getUid()).getDepartmentId())).getDepartmentName());
                    ad.setFilename(as.getFilename());
                    ad.setTimes(as.getTimes());
                    sr.set(i,ad);
                }
            }

            }
        }
        return PageListUtil.getPageList(sr.size(),page,sr,pageCount);
    }



}
