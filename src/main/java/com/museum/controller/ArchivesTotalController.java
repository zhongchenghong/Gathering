package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IArchivesTotalService;
import com.museum.domain.ArchivesTotal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 档案统计 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-27
 */
@Api(tags = {"信息中心----档案统计"})
@RestController
@RequestMapping("/archives-total")
public class ArchivesTotalController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IArchivesTotalService archivesTotalService;


    @ApiOperation(value = "新增档案统计")
    @PostMapping()
    public int add(@RequestBody ArchivesTotal archivesTotal){
        return archivesTotalService.add(archivesTotal);
    }

    @ApiOperation(value = "删除档案统计")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return archivesTotalService.delete(id);
    }

    @ApiOperation(value = "更新档案统计")
    @PutMapping()
    public int update(@RequestBody ArchivesTotal archivesTotal){
        return archivesTotalService.updateData(archivesTotal);
    }

    @ApiOperation(value = "查询档案统计分页数据")
    @GetMapping("/getList")
    public List<ArchivesTotal> findListByPage(){
        return archivesTotalService.list();
    }

    @ApiOperation(value = "id查询档案统计")
    @GetMapping("{id}")
    public ArchivesTotal findById(@PathVariable Long id){
        return archivesTotalService.findById(id);
    }

}
