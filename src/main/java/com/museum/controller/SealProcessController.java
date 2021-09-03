package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ISealProcessService;
import com.museum.domain.SealProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用章流程 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-26
 */
@Api(tags = {"用章流程"})
@RestController
@RequestMapping("/seal-process")
public class SealProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ISealProcessService sealProcessService;


    @ApiOperation(value = "新增用章流程")
    @PostMapping()
    public int add(@RequestBody SealProcess sealProcess){
        return sealProcessService.add(sealProcess);
    }

    @ApiOperation(value = "删除用章流程")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return sealProcessService.delete(id);
    }

    @ApiOperation(value = "更新用章流程")
    @PutMapping()
    public int update(@RequestBody SealProcess sealProcess){
        return sealProcessService.updateData(sealProcess);
    }

    @ApiOperation(value = "查询用章流程分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<SealProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return sealProcessService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询用章流程")
    @GetMapping("{id}")
    public SealProcess findById(@PathVariable Long id){
        return sealProcessService.findById(id);
    }

}
