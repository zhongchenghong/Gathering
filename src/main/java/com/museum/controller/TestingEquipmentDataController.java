package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ITestingEquipmentDataService;
import com.museum.domain.TestingEquipmentData;
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
@Api(tags = {"保护信息管理系统-检测数据"})
@RestController
@RequestMapping("/testing-equipment-data")
public class TestingEquipmentDataController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ITestingEquipmentDataService testingEquipmentDataService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody TestingEquipmentData testingEquipmentData){
        return testingEquipmentDataService.add(testingEquipmentData);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return testingEquipmentDataService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody TestingEquipmentData testingEquipmentData){
        return testingEquipmentDataService.updateData(testingEquipmentData);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<TestingEquipmentData> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String equipmentname){
        QueryWrapper queryWrappers  = new QueryWrapper();
        queryWrappers.eq("equipmentname",equipmentname);
        return testingEquipmentDataService.page(testingEquipmentDataService.findListByPage(page, pageCount),queryWrappers);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public TestingEquipmentData findById(@PathVariable Long id){
        return testingEquipmentDataService.findById(id);
    }

}
