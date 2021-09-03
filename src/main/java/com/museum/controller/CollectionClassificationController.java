package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ICollectionClassificationService;
import com.museum.domain.CollectionClassification;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 藏品管理系统（分类统计） 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
@Api(tags = {"保管研究部-----藏品管理系统（分类统计）"})
@RestController
@RequestMapping("/collection-classification")
public class CollectionClassificationController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICollectionClassificationService collectionClassificationService;


    @ApiOperation(value = "新增藏品管理系统（分类统计）")
    @PostMapping()
    public int add(@RequestBody CollectionClassification collectionClassification){
        return collectionClassificationService.add(collectionClassification);
    }

    @ApiOperation(value = "删除藏品管理系统（分类统计）")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return collectionClassificationService.delete(id);
    }

    @ApiOperation(value = "更新藏品管理系统（分类统计）")
    @PutMapping()
    public int update(@RequestBody CollectionClassification collectionClassification){
        return collectionClassificationService.updateData(collectionClassification);
    }

    @ApiOperation(value = "查询藏品管理系统（分类统计）分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<CollectionClassification> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String collection_year){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("collection_year", collection_year);
        return collectionClassificationService.page(collectionClassificationService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询藏品管理系统（分类统计）")
    @GetMapping("{id}")
    public CollectionClassification findById(@PathVariable Long id){
        return collectionClassificationService.findById(id);
    }

}
