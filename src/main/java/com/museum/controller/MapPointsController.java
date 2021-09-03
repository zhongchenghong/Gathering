package com.museum.controller;

import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IMapPointsService;
import com.museum.domain.MapPoints;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-06-24
 */
@Api(tags = {"GIS-----地图点位类型"})
@RestController
@RequestMapping("/map-points")
public class MapPointsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMapPointsService mapPointsService;


    @ApiOperation(value = "新增点位类型")
    @PostMapping("/add")
    public int add(@RequestBody MapPoints mapPoints){
        mapPoints.setCreatetimes(SystemDateUtils.getStrDate());
        return mapPointsService.add(mapPoints);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return mapPointsService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody MapPoints mapPoints){
        return mapPointsService.updateData(mapPoints);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<MapPoints> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return mapPointsService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public MapPoints findById(@PathVariable Long id){
        return mapPointsService.findById(id);
    }

}
