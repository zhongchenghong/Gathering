package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IFileAccessProcessService;
import com.museum.domain.FileAccessProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 资料采集制作流程表 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
@Api(tags = {"资料采集制作流程表"})
@RestController
@RequestMapping("/file-access-process")
public class FileAccessProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IFileAccessProcessService fileAccessProcessService;


    @ApiOperation(value = "新增资料采集制作流程表")
    @PostMapping()
    public int add(@RequestBody FileAccessProcess fileAccessProcess){
        return fileAccessProcessService.add(fileAccessProcess);
    }

    @ApiOperation(value = "删除资料采集制作流程表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return fileAccessProcessService.delete(id);
    }

    @ApiOperation(value = "更新资料采集制作流程表")
    @PutMapping()
    public int update(@RequestBody FileAccessProcess fileAccessProcess){
        return fileAccessProcessService.updateData(fileAccessProcess);
    }

    @ApiOperation(value = "查询资料采集制作流程表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<FileAccessProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return fileAccessProcessService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询资料采集制作流程表")
    @GetMapping("{id}")
    public FileAccessProcess findById(@PathVariable Long id){
        return fileAccessProcessService.findById(id);
    }

}
