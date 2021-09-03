package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ITestingEquipmentService;
import com.museum.domain.TestingEquipment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 保护信息管理系统设备管理 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-04
 */
@Api(tags = {"保护信息管理系统设备管理"})
@RestController
@RequestMapping("/testing-equipment")
public class TestingEquipmentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ITestingEquipmentService testingEquipmentService;


    @ApiOperation(value = "新增保护信息管理系统设备管理")
    @PostMapping()
    public int add(@RequestBody TestingEquipment testingEquipment){
        return testingEquipmentService.add(testingEquipment);
    }

    @ApiOperation(value = "删除保护信息管理系统设备管理")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return testingEquipmentService.delete(id);
    }

    @ApiOperation(value = "更新保护信息管理系统设备管理")
    @PutMapping()
    public int update(@RequestBody TestingEquipment testingEquipment){
        return testingEquipmentService.updateData(testingEquipment);
    }

    @ApiOperation(value = "查询保护信息管理系统设备管理分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<TestingEquipment> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return testingEquipmentService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询保护信息管理系统设备管理")
    @GetMapping("{id}")
    public TestingEquipment findById(@PathVariable Long id){
        return testingEquipmentService.findById(id);
    }

}
