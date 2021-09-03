package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IArchitectureService;
import com.museum.domain.Architecture;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据中心-古建数据 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Api(tags = {"数据中心-古建数据"})
@RestController
@RequestMapping("/architecture")
public class ArchitectureController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IArchitectureService architectureService;


    @ApiOperation(value = "新增数据中心-古建数据")
    @PostMapping()
    public int add(@RequestBody Architecture architecture){
        return architectureService.add(architecture);
    }

    @ApiOperation(value = "删除数据中心-古建数据")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return architectureService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-古建数据")
    @PutMapping()
    public int update(@RequestBody Architecture architecture){
        return architectureService.updateData(architecture);
    }

    @ApiOperation(value = "查询数据中心-古建数据分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Architecture> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return architectureService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询数据中心-古建数据")
    @GetMapping("{id}")
    public Architecture findById(@PathVariable Long id){
        return architectureService.findById(id);
    }

}
