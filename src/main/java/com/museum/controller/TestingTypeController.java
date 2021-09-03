package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ITestingTypeService;
import com.museum.domain.TestingType;
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
@Api(tags = {"监测数据类型"})
@RestController
@RequestMapping("/testing-type")
public class TestingTypeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ITestingTypeService testingTypeService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody TestingType testingType){
        return testingTypeService.add(testingType);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return testingTypeService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody TestingType testingType){
        return testingTypeService.updateData(testingType);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<TestingType> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return testingTypeService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public TestingType findById(@PathVariable Long id){
        return testingTypeService.findById(id);
    }

}
