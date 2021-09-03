package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IExhibitionLinkageService;
import com.museum.domain.ExhibitionLinkage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 陈列展览三级联动 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Api(tags = {"陈列展览部---目录三级联动"})
@RestController
@RequestMapping("/exhibition-linkage")
public class ExhibitionLinkageController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IExhibitionLinkageService exhibitionLinkageService;


    @ApiOperation(value = "新增陈列展览三级联动")
    @PostMapping()
    public int add(@RequestBody ExhibitionLinkage exhibitionLinkage){
        return exhibitionLinkageService.add(exhibitionLinkage);
    }

    @ApiOperation(value = "删除陈列展览三级联动")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return exhibitionLinkageService.delete(id);
    }

    @ApiOperation(value = "更新陈列展览三级联动")
    @PutMapping()
    public int update(@RequestBody ExhibitionLinkage exhibitionLinkage){
        return exhibitionLinkageService.updateData(exhibitionLinkage);
    }

    @ApiOperation(value = "查询陈列展览三级联动分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ExhibitionLinkage> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return exhibitionLinkageService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "查询陈列展览三级联动展览列")
    @GetMapping("/getfind")
    public List<ExhibitionLinkage> findById(){
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("typeid",0);
        return exhibitionLinkageService.list(queryWrappet);
    }

    @ApiOperation(value = "通过id查询三级联动类别")
    @GetMapping("/classification")
    public List<ExhibitionLinkage> findByParentId(Long exhibitionId){
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("exhibitionId",exhibitionId);
        queryWrappet.eq("typeid",1);
        return exhibitionLinkageService.list(queryWrappet);
    }

    @ApiOperation(value = "通过id查询三级联动具体类型")
    @GetMapping("/getentity")
    public List<ExhibitionLinkage> findById(Long exhibitionId){
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("exhibitionId",exhibitionId);
        queryWrappet.eq("typeid",2);
        return exhibitionLinkageService.list(queryWrappet);
    }

}
