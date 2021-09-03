package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.domain.Account;
import com.museum.domain.ImageData;
import com.museum.domain.ImageDataProcessList;
import com.museum.service.IAccountService;
import com.museum.service.IDepartmentService;
import com.museum.service.IImageDataService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IImageDataProcessService;
import com.museum.domain.ImageDataProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-15
 */
@Api(tags = {"信息中心-----影像资料申请流程"})
@RestController
@RequestMapping("/image-data-process")
public class ImageDataProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IImageDataProcessService imageDataProcessService;

    @Resource
    private IAccountService accountService;

    @Resource
    private IDepartmentService departmentService;

    @Resource
    private IImageDataService imageDataService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody ImageDataProcess imageDataProcess){
        imageDataProcess.setCreateTime(SystemDateUtils.getStrDate());
        return imageDataProcessService.add(imageDataProcess);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return imageDataProcessService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody ImageDataProcess imageDataProcess){
        return imageDataProcessService.updateData(imageDataProcess);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ImageDataProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        QueryWrapper queryWrapp  = new QueryWrapper();
        queryWrapp.select().orderByDesc("department_director_time");
//        queryWrapp.eq("image_dataId",tmageCenterIdea.getId());
        return imageDataProcessService.page(imageDataProcessService.findListByPage(page, pageCount),queryWrapp);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("/findById")
    public List<ImageDataProcessList> findById(Long id){
        QueryWrapper queryWrappers  = new QueryWrapper();
        queryWrappers.like("image_dataId",id);
        ImageDataProcess is=imageDataProcessService.getOne(queryWrappers);
        Account acc2=null;
        Account acc=null;
        Account acc1=null;

        ImageData idm=imageDataService.findById(id);


        List<ImageDataProcessList> im = new ArrayList<ImageDataProcessList>();

        //员工
        if(is!=null&&is.getUid()!=null) {
            ImageDataProcessList ip = new ImageDataProcessList();
            acc1 = accountService.findById(is.getUid().longValue());
            ip.setDepment(departmentService.findById(Long.valueOf(acc1.getDepartmentId())).getDepartmentName());
            is.setAlppyname(acc1.getName());
            //员工
            ip.setName(acc1.getName());
            ip.setTime(is.getCreateTime());
            ip.setPicture(acc1.getPicture());
            im.add(0,ip);
            ImageDataProcessList ip1 = new ImageDataProcessList();
        }
        //部门主任
        if(is!=null&&is.getDepartmentDirectorId()!=null){
            acc=accountService.findById(is.getDepartmentDirectorId().longValue());
            is.setBuname(acc.getName());
            ImageDataProcessList ip1 = new ImageDataProcessList();
            //部门主任
            ip1.setDepment(departmentService.findById(Long.valueOf(acc.getDepartmentId())).getDepartmentName());
            ip1.setName(acc.getName());
            ip1.setTime(is.getDepartmentDirectorTime()+"");
            ip1.setIdea(is.getDirectorIdea());
            ip1.setPicture(acc.getPicture());
            ip1.setState(is.getDepartmentDirectorState()+"");
            im.add(1,ip1);
        }

        if(is!=null&&is.getInformationCenter()!=null&&is.getInformationCenterState()==0){

            //信息中心主任
            acc2=accountService.findById(is.getInformationCenter().longValue());
            is.setXinname(acc2.getName());

            //信息中心主任
            ImageDataProcessList ip2 = new ImageDataProcessList();
            ip2.setDepment(departmentService.findById(Long.valueOf(acc2.getDepartmentId())).getDepartmentName());
            ip2.setName(acc2.getName());
            ip2.setTime(is.getInformationCenterTime()+"");
            ip2.setIdea(is.getCenterIdea());
            ip2.setPicture(acc2.getPicture());
            ip2.setState(is.getInformationCenterState()+"");
            if(is==null&&is.getDepartmentDirectorId()==null){
                im.add(1,ip2);
            }else{
                im.add(2,ip2);
            }


            //影像资料下发
            ImageDataProcessList ip3 = new ImageDataProcessList();
            ip3.setDepment(departmentService.findById(Long.valueOf(acc2.getDepartmentId())).getDepartmentName());
            ip3.setName(acc2.getName());
            ip3.setTime(is.getInformationCenterTime()+"");
            ip3.setIdea(idm.getFileName());
            ip3.setPicture(acc2.getPicture());
            if(is==null&&is.getDepartmentDirectorId()==null){
            im.add(2, ip3);
            }else{
                im.add(3, ip3);
            }
        }
        return im;
    }



}
