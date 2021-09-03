package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ICulturalListService;
import com.museum.domain.CulturalList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 物品列表 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Api(tags = {"物品列表"})
@RestController
@RequestMapping("/cultural-list")
public class CulturalListController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICulturalListService culturalListService;


    @ApiOperation(value = "新增物品列表")
    @PostMapping()
    public int add(@RequestBody CulturalList culturalList){
        return culturalListService.add(culturalList);
    }

    @ApiOperation(value = "删除物品列表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return culturalListService.delete(id);
    }

    @ApiOperation(value = "更新物品列表")
    @PutMapping()
    public int update(@RequestBody CulturalList culturalList){
        return culturalListService.updateData(culturalList);
    }

    @ApiOperation(value = "查询物品列表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<CulturalList> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return culturalListService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询物品列表")
    @GetMapping("{id}")
    public CulturalList findById(@PathVariable Long id){
        return culturalListService.findById(id);
    }

}
