package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.domain.ArchiveBydepartment;
import com.museum.domain.ArchivesTotal;
import com.museum.service.IArchivesTotalService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IArchivesService;
import com.museum.domain.Archives;
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
@Api(tags = {"档案管理"})
@RestController
@RequestMapping("/archives")
public class ArchivesController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IArchivesService archivesService;

    @Resource
    private IArchivesTotalService archivesTotalService;



    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Archives archives){
        int borrow = -1;
        int consul =-1;
        ArchivesTotal at = new ArchivesTotal();
        archives.setCreateTime(SystemDateUtils.getStrDate());
        List<ArchivesTotal> archivesTotal = archivesTotalService.list();
        //统计借阅、查阅总数
        if(archives.getTypes()==1){
            consul=archivesTotal.get(0).getConsulttotal()+1;
        }else if(archives.getTypes()==0){
            borrow=archivesTotal.get(0).getBorrowingtotal()+1;
        }
        //获取借阅数
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("types", 0);
        int da=archivesService.count(queryWrapper);
        at.setBorrowingtotal(borrow);
        at.setConsulttotal(consul);
        at.setCurrent(da);
        at.setTotal(archivesService.count());

        //获取借阅数
        QueryWrapper queryWrappers = new QueryWrapper();
        queryWrappers.eq("id", archivesTotal.get(0).getId());
        archivesTotalService.update(at,queryWrappers);
        return archivesService.add(archives);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return archivesService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Archives archives){
        return archivesService.updateData(archives);
    }

    @ApiOperation(value = "档案管理查阅/借阅分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/findListByPage")
    public IPage<Archives> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,@RequestParam int type,@RequestParam int consultType,@RequestParam String name){
        QueryWrapper queryWrapper  = new QueryWrapper();
        //档案名称查询
        if(type==1){
            queryWrapper.eq("archives_name",name);
        }
        //借阅人或查阅人
        if(type==2){
            queryWrapper.eq("borrowing_name",name);
        }
        //2借阅/1查阅人
        if(consultType==1) {
            queryWrapper.eq("types", consultType);
        }else{

        }
        return archivesService.page(archivesService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询详情")
    @GetMapping("{id}")
    public Archives findById(@PathVariable Long id){
        return archivesService.findById(id);
    }

    @ApiOperation(value = "部门缴纳档案查询")
    @PostMapping("/getArchiveBydepartment")
    public List<ArchiveBydepartment> getArchives(){
        return archivesService.selectArchiveBydepartment();
    }

    @ApiOperation(value = "档案分类统计")
    @PostMapping("/getArchiveBydeptment")
    public List<ArchiveBydepartment> getArchiv(String time){
        List<ArchiveBydepartment>  ar= archivesService.selectarchivesTypeId(time);
        if(ar.size()>0){
            for (int i=0;i<ar.size();i++){
                ar.get(i).setPercentage(ar.get(i).getCount()/ar.get(i).getTotal()*100+"");
            }
        }
        return ar;
    }

    @ApiOperation(value = "档案总计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/findListByPages")
    public IPage<Archives> findListByPages(@RequestParam Integer page,
                                          @RequestParam Integer pageCount,String archivesTypeId,String name){
        QueryWrapper queryWrapper  = new QueryWrapper();
        //档案名称查询
        if(name!=null&&!"".equals(name)){
            queryWrapper.eq("archives_name",name);
        }
        //借阅人或查阅人
        if(archivesTypeId!=null&&!"".equals(archivesTypeId)){
            queryWrapper.eq("archivesTypeId",archivesTypeId);
        }

        return archivesService.page(archivesService.findListByPage(page, pageCount),queryWrapper);
    }


    @ApiOperation(value = "缴纳档案")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/findListByPag")
    public IPage<Archives> findListByPag(@RequestParam Integer page,
                                          @RequestParam Integer pageCount,@RequestParam int type,@RequestParam int consultType,@RequestParam String name){
        QueryWrapper queryWrapper  = new QueryWrapper();
        //档案名称查询
        if(type==1){
            queryWrapper.eq("archives_name",name);
        }
        //借阅人或查阅人
        if(type==2){
            queryWrapper.eq("borrowing_name",name);
        }
        //2借阅/1查阅人
        if(consultType==1) {
            queryWrapper.eq("types", consultType);
        }else{

        }
        return archivesService.page(archivesService.findListByPage(page, pageCount),queryWrapper);
    }



}
