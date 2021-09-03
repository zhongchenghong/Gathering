package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IDeviceManagementService;
import com.museum.domain.DeviceManagement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 信息中心设备管理 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Api(tags = {"信息中心设备管理"})
@RestController
@RequestMapping("/device-management")
public class DeviceManagementController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IDeviceManagementService deviceManagementService;


    @ApiOperation(value = "新增信息中心设备管理")
    @PostMapping()
    public int add(@RequestBody DeviceManagement deviceManagement){
        return deviceManagementService.add(deviceManagement);
    }

    @ApiOperation(value = "删除信息中心设备管理")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return deviceManagementService.delete(id);
    }

    @ApiOperation(value = "更新信息中心设备管理")
    @PutMapping()
    public int update(@RequestBody DeviceManagement deviceManagement){
        return deviceManagementService.updateData(deviceManagement);
    }

    @ApiOperation(value = "查询信息中心设备管理分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<DeviceManagement> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return deviceManagementService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "信息中心网络设备统计")
    @GetMapping("/getNetwork")
    public int getNetwork(){
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("type",1);
        return deviceManagementService.list(queryWrappet).size();
    }

    @ApiOperation(value = "信息中心安全设备统计")
    @GetMapping("/security")
    public int getSecurity(){
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("type",2);
        return deviceManagementService.list(queryWrappet).size();
    }

    @ApiOperation(value = "信息中心无线wilf统计")
    @GetMapping("/getwilf")
    public int  getwilf(){
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("type",3);
        return deviceManagementService.list(queryWrappet).size();
    }

}
