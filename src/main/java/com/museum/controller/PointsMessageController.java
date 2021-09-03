package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IPointsMessageService;
import com.museum.domain.PointsMessage;
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
 * @since 2021-06-24
 */
@Api(tags = {"GIS----地图坐标"})
@RestController
@RequestMapping("/points-message")
public class PointsMessageController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPointsMessageService pointsMessageService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody PointsMessage pointsMessage){
        return pointsMessageService.add(pointsMessage);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return pointsMessageService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody PointsMessage pointsMessage){
        return pointsMessageService.updateData(pointsMessage);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<PointsMessage> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return pointsMessageService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "获取坐标点")
    @GetMapping("/getbytype")
    public List<PointsMessage> findById(String map_pointsId){
        QueryWrapper queryWrappers  = new QueryWrapper();
        if(map_pointsId!=null&&!"".equals(map_pointsId)){
            queryWrappers.like("map_pointsId",map_pointsId);}
        return pointsMessageService.list(queryWrappers);
    }

}
