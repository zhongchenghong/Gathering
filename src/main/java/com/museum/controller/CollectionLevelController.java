package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ICollectionLevelService;
import com.museum.domain.CollectionLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 藏品级别统计 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
@Api(tags = {"保管研究部-----藏品级别统计"})
@RestController
@RequestMapping("/collection-level")
public class CollectionLevelController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICollectionLevelService collectionLevelService;


    @ApiOperation(value = "新增藏品级别统计")
    @PostMapping()
    public int add(@RequestBody CollectionLevel collectionLevel){
        return collectionLevelService.add(collectionLevel);
    }

    @ApiOperation(value = "删除藏品级别统计")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return collectionLevelService.delete(id);
    }

    @ApiOperation(value = "更新藏品级别统计")
    @PutMapping()
    public int update(@RequestBody CollectionLevel collectionLevel){
        return collectionLevelService.updateData(collectionLevel);
    }

    @ApiOperation(value = "查询藏品级别统计分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<CollectionLevel> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String collection_year){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("collection_year", collection_year);
        return collectionLevelService.page(collectionLevelService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询藏品级别统计")
    @GetMapping("{id}")
    public CollectionLevel findById(@PathVariable Long id){
        return collectionLevelService.findById(id);
    }

    @ApiOperation(value = "藏品级别统计")
    @GetMapping("/getsum")
    public CollectionLevel findById(){
        return collectionLevelService.getsum();
    }

}
