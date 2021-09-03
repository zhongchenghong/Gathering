/*
package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IFinanceContentService;
import com.museum.domain.FinanceContent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 *//*

@Api(tags = {"财务用款计划申报内容"})
@RestController
@RequestMapping("/finance-content")
public class FinanceContentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IFinanceContentService financeContentService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody FinanceContent financeContent){
        return financeContentService.add(financeContent);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return financeContentService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody FinanceContent financeContent){
        return financeContentService.updateData(financeContent);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<FinanceContent> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return financeContentService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public FinanceContent findById(@PathVariable Long id){
        return financeContentService.findById(id);
    }

}
*/
