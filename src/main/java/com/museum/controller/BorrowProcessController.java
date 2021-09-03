package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IBorrowProcessService;
import com.museum.domain.BorrowProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 档案借阅流程 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-28
 */
@Api(tags = {"档案借阅流程"})
@RestController
@RequestMapping("/borrow-process")
public class BorrowProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBorrowProcessService borrowProcessService;


    @ApiOperation(value = "新增档案借阅流程")
    @PostMapping()
    public int add(@RequestBody BorrowProcess borrowProcess){
        return borrowProcessService.add(borrowProcess);
    }

    @ApiOperation(value = "删除档案借阅流程")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return borrowProcessService.delete(id);
    }

    @ApiOperation(value = "更新档案借阅流程")
    @PutMapping()
    public int update(@RequestBody BorrowProcess borrowProcess){
        return borrowProcessService.updateData(borrowProcess);
    }

    @ApiOperation(value = "查询档案借阅流程分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<BorrowProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return borrowProcessService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询档案借阅流程")
    @GetMapping("{id}")
    public BorrowProcess findById(@PathVariable Long id){
        return borrowProcessService.findById(id);
    }

}
