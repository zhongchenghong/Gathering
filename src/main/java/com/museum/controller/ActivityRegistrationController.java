package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IActivityRegistrationService;
import com.museum.domain.ActivityRegistration;
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
 * @since 2021-08-05
 */
@Api(tags = {"活动报名小程序接口---活动报名小程序接口"})
@RestController
@RequestMapping("/activity-registration")
public class ActivityRegistrationController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IActivityRegistrationService activityRegistrationService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody ActivityRegistration activityRegistration){
        return activityRegistrationService.add(activityRegistration);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return activityRegistrationService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody ActivityRegistration activityRegistration){
        return activityRegistrationService.updateData(activityRegistration);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ActivityRegistration> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return activityRegistrationService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public ActivityRegistration findById(@PathVariable Long id){
        return activityRegistrationService.findById(id);
    }

}
