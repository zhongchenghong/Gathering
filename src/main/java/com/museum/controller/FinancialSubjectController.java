package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IFinancialSubjectService;
import com.museum.domain.FinancialSubject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 财务部科目 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 */
@Api(tags = {"财务部科目"})
@RestController
@RequestMapping("/financial-subject")
public class FinancialSubjectController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IFinancialSubjectService financialSubjectService;


    @ApiOperation(value = "新增财务部科目")
    @PostMapping()
    public int add(@RequestBody FinancialSubject financialSubject){
        return financialSubjectService.add(financialSubject);
    }

    @ApiOperation(value = "删除财务部科目")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return financialSubjectService.delete(id);
    }

    @ApiOperation(value = "更新财务部科目")
    @PutMapping()
    public int update(@RequestBody FinancialSubject financialSubject){
        return financialSubjectService.updateData(financialSubject);
    }

    @ApiOperation(value = "查询财务部科目分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<FinancialSubject> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return financialSubjectService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询财务部科目")
    @GetMapping("{id}")
    public FinancialSubject findById(@PathVariable Long id){
        return financialSubjectService.findById(id);
    }

}
