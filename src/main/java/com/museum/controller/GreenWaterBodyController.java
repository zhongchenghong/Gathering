package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IGreenWaterBodyService;
import com.museum.domain.GreenWaterBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据中心-绿地水体面积 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Api(tags = {"数据中心-绿地水体面积"})
@RestController
@RequestMapping("/green-water-body")
public class GreenWaterBodyController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IGreenWaterBodyService greenWaterBodyService;


    @ApiOperation(value = "新增数据中心-绿地水体面积")
    @PostMapping()
    public int add(@RequestBody GreenWaterBody greenWaterBody){
        greenWaterBody.setCreatimes(SystemDateUtils.getStrDate());
        return greenWaterBodyService.add(greenWaterBody);
    }

    @ApiOperation(value = "删除数据中心-绿地水体面积")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return greenWaterBodyService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-绿地水体面积")
    @PutMapping()
    public int update(@RequestBody GreenWaterBody greenWaterBody){
        return greenWaterBodyService.updateData(greenWaterBody);
    }

    @ApiOperation(value = "查询数据中心-绿地水体面积分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<GreenWaterBody> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String type,String region){
        QueryWrapper queryWrapper = new QueryWrapper();
        if(region!=null&&!"".equals(region)){
            queryWrapper.like("region",region);
        }
        queryWrapper.select("sum(area) as total");
        return greenWaterBodyService.page(greenWaterBodyService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询数据中心-绿地水体面积")
    @GetMapping("{id}")
    public GreenWaterBody findById(@PathVariable Long id){
        return greenWaterBodyService.findById(id);
    }

}
