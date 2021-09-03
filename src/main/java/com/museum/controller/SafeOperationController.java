package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ISafeOperationService;
import com.museum.domain.SafeOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 泰合信息安全运营中心系统 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-27
 */
@Api(tags = {"泰合信息安全运营中心系统"})
@RestController
@RequestMapping("/safe-operation")
public class SafeOperationController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ISafeOperationService safeOperationService;


    @ApiOperation(value = "新增泰合信息安全运营中心系统")
    @PostMapping()
    public int add(@RequestBody SafeOperation safeOperation){
        return safeOperationService.add(safeOperation);
    }

    @ApiOperation(value = "删除泰合信息安全运营中心系统")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return safeOperationService.delete(id);
    }

    @ApiOperation(value = "更新泰合信息安全运营中心系统")
    @PutMapping()
    public int update(@RequestBody SafeOperation safeOperation){
        return safeOperationService.updateData(safeOperation);
    }

    @ApiOperation(value = "查询泰合信息安全运营中心系统分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<SafeOperation> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return safeOperationService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询泰合信息安全运营中心系统")
    @GetMapping("{id}")
    public SafeOperation findById(@PathVariable Long id){
        return safeOperationService.findById(id);
    }

}
