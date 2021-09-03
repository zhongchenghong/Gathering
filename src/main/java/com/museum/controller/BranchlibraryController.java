package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IBranchlibraryService;
import com.museum.domain.Branchlibrary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 分管馆长跟部门绑定 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-28
 */
@Api(tags = {"组件---分管馆长跟部门绑定"})
@RestController
@RequestMapping("/branchlibrary")
public class BranchlibraryController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBranchlibraryService branchlibraryService;


    @ApiOperation(value = "新增分管馆长跟部门绑定")
    @PostMapping()
    public int add(@RequestBody Branchlibrary branchlibrary){
        return branchlibraryService.add(branchlibrary);
    }

    @ApiOperation(value = "删除分管馆长跟部门绑定")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return branchlibraryService.delete(id);
    }

    @ApiOperation(value = "更新分管馆长跟部门绑定")
    @PutMapping()
    public int update(@RequestBody Branchlibrary branchlibrary){
        return branchlibraryService.updateData(branchlibrary);
    }

    @ApiOperation(value = "查询分管馆长跟部门绑定分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Branchlibrary> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return branchlibraryService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询分管馆长跟部门绑定")
    @GetMapping("{id}")
    public Branchlibrary findById(@PathVariable Long id){
        return branchlibraryService.findById(id);
    }

}
