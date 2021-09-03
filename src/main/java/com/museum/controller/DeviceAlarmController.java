package com.museum.controller;

import com.museum.domain.AlarmMessage;
import com.museum.util.page.PageList;
import com.museum.util.page.PageListUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IDeviceAlarmService;
import com.museum.domain.DeviceAlarm;
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
 * @since 2021-08-17
 */
@Api(tags = {"信息中心---设备告警"})
@RestController
@RequestMapping("/device-alarm")
public class DeviceAlarmController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IDeviceAlarmService deviceAlarmService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody DeviceAlarm deviceAlarm){
        return deviceAlarmService.add(deviceAlarm);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return deviceAlarmService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody DeviceAlarm deviceAlarm){
        return deviceAlarmService.updateData(deviceAlarm);
    }

    @ApiOperation(value = "查询设备告警信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public PageList<AlarmMessage> findListByPage(@RequestParam Integer page,
                                                 @RequestParam Integer pageCount){
        return PageListUtil.getPageList(deviceAlarmService.getalarm().size(),page,deviceAlarmService.getalarm(),pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public DeviceAlarm findById(@PathVariable Long id){
        return deviceAlarmService.findById(id);
    }

}
