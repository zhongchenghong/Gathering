package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ICulturalAlpplyListService;
import com.museum.domain.CulturalAlpplyList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 子类物品列表 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Api(tags = {"子类物品列表"})
@RestController
@RequestMapping("/cultural-alpply-list")
public class CulturalAlpplyListController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICulturalAlpplyListService culturalAlpplyListService;


    @ApiOperation(value = "新增子类物品列表")
    @PostMapping()
    public int add(@RequestBody CulturalAlpplyList culturalAlpplyList){
        return culturalAlpplyListService.add(culturalAlpplyList);
    }

    @ApiOperation(value = "删除子类物品列表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return culturalAlpplyListService.delete(id);
    }

    @ApiOperation(value = "更新子类物品列表")
    @PutMapping()
    public int update(@RequestBody CulturalAlpplyList culturalAlpplyList){
        return culturalAlpplyListService.updateData(culturalAlpplyList);
    }

    @ApiOperation(value = "查询子类物品列表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<CulturalAlpplyList> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return culturalAlpplyListService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询子类物品列表")
    @GetMapping("{id}")
    public CulturalAlpplyList findById(@PathVariable Long id){
        return culturalAlpplyListService.findById(id);
    }

}
