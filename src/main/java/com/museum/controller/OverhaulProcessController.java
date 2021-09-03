package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IOverhaulProcessService;
import com.museum.domain.OverhaulProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 水电维修维护申请流程 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
@Api(tags = {"水电维修维护申请流程"})
@RestController
@RequestMapping("/overhaul-process")
public class OverhaulProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IOverhaulProcessService overhaulProcessService;


    @ApiOperation(value = "新增水电维修维护申请流程")
    @PostMapping()
    public int add(@RequestBody OverhaulProcess overhaulProcess){
        return overhaulProcessService.add(overhaulProcess);
    }

    @ApiOperation(value = "删除水电维修维护申请流程")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return overhaulProcessService.delete(id);
    }

    @ApiOperation(value = "更新水电维修维护申请流程")
    @PutMapping()
    public int update(@RequestBody OverhaulProcess overhaulProcess){
        return overhaulProcessService.updateData(overhaulProcess);
    }

    @ApiOperation(value = "查询水电维修维护申请流程分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<OverhaulProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return overhaulProcessService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询水电维修维护申请流程")
    @GetMapping("{id}")
    public OverhaulProcess findById(@PathVariable Long id){
        return overhaulProcessService.findById(id);
    }

}
