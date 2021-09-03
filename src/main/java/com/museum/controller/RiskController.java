package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IRiskService;
import com.museum.domain.Risk;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 车辆保险险种 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Api(tags = {"车辆保险险种"})
@RestController
@RequestMapping("/risk")
public class RiskController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRiskService riskService;


    @ApiOperation(value = "新增车辆保险险种")
    @PostMapping()
    public int add(@RequestBody Risk risk){
        return riskService.add(risk);
    }

    @ApiOperation(value = "删除车辆保险险种")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return riskService.delete(id);
    }

    @ApiOperation(value = "更新车辆保险险种")
    @PutMapping()
    public int update(@RequestBody Risk risk){
        return riskService.updateData(risk);
    }

    @ApiOperation(value = "查询车辆保险险种分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Risk> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return riskService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询车辆保险险种")
    @GetMapping("{id}")
    public Risk findById(@PathVariable Long id){
        return riskService.findById(id);
    }

}
