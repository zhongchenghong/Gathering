package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IBorrowingResultsService;
import com.museum.domain.BorrowingResults;
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
 * @since 2021-07-30
 */
@Api(tags = {"信息中心---档案类型组件"})
@RestController
@RequestMapping("/borrowing-results")
public class BorrowingResultsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBorrowingResultsService borrowingResultsService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody BorrowingResults borrowingResults){
        return borrowingResultsService.add(borrowingResults);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return borrowingResultsService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody BorrowingResults borrowingResults){
        return borrowingResultsService.updateData(borrowingResults);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<BorrowingResults> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return borrowingResultsService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public BorrowingResults findById(@PathVariable Long id){
        return borrowingResultsService.findById(id);
    }

}
