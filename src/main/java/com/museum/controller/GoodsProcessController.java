package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IGoodsProcessService;
import com.museum.domain.GoodsProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 资料采集制作流程表 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Api(tags = {"信息中心-----资料采集制作流程表"})
@RestController
@RequestMapping("/goods-process")
public class GoodsProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IGoodsProcessService goodsProcessService;


    @ApiOperation(value = "新增资料采集制作流程表")
    @PostMapping()
    public int add(@RequestBody GoodsProcess goodsProcess){
        return goodsProcessService.add(goodsProcess);
    }

    @ApiOperation(value = "删除资料采集制作流程表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return goodsProcessService.delete(id);
    }

    @ApiOperation(value = "更新资料采集制作流程表")
    @PutMapping()
    public int update(@RequestBody GoodsProcess goodsProcess){
        return goodsProcessService.updateData(goodsProcess);
    }

    @ApiOperation(value = "查询资料采集制作流程表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<GoodsProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return goodsProcessService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询资料采集制作流程表")
    @GetMapping("{id}")
    public GoodsProcess findById(@PathVariable Long id){
        return goodsProcessService.findById(id);
    }

}
