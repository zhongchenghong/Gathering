package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IMonitorService;
import com.museum.domain.Monitor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统监听 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-26
 */
@Api(tags = {"通用功能-----系统监听"})
@RestController
@RequestMapping("/monitor")
public class MonitorController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMonitorService monitorService;


    @ApiOperation(value = "新增系统监听")
    @PostMapping()
    public int add(@RequestBody Monitor monitor){
        return monitorService.add(monitor);
    }

    @ApiOperation(value = "删除系统监听")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return monitorService.delete(id);
    }

    @ApiOperation(value = "更新系统监听")
    @PutMapping()
    public int update(@RequestBody Monitor monitor){
        return monitorService.updateData(monitor);
    }

    @ApiOperation(value = "查询系统监听分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Monitor> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return monitorService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询系统监听")
    @GetMapping("{id}")
    public Monitor findById(@PathVariable Long id){
        return monitorService.findById(id);
    }

}
