package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IGardenGreenService;
import com.museum.domain.GardenGreen;
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
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-12
 */
@Api(tags = {"园林景观---绿化统计"})
@RestController
@RequestMapping("/garden-green")
public class GardenGreenController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IGardenGreenService gardenGreenService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody GardenGreen gardenGreen){
        return gardenGreenService.add(gardenGreen);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return gardenGreenService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody GardenGreen gardenGreen){
        return gardenGreenService.updateData(gardenGreen);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<GardenGreen> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String type){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("type", type);
        return gardenGreenService.page(gardenGreenService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public GardenGreen findById(@PathVariable Long id){
        return gardenGreenService.findById(id);
    }

    @ApiOperation(value = "水体绿化面积统计")
    @GetMapping("/getGardenGreenCount")
    public List<GardenGreen> findById(String type){
        return gardenGreenService.getGardenGreenCount(type);
    }

}
