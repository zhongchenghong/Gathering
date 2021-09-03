package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IFinanceApplyPlanProcessService;
import com.museum.domain.FinanceApplyPlanProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 财务用款计划申请流程 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
@Api(tags = {"财务部------用款计划申请流程"})
@RestController
@RequestMapping("/finance-apply-plan-process")
public class FinanceApplyPlanProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IFinanceApplyPlanProcessService financeApplyPlanProcessService;


    @ApiOperation(value = "新增财务用款计划申请流程")
    @PostMapping()
    public int add(@RequestBody FinanceApplyPlanProcess financeApplyPlanProcess){
        return financeApplyPlanProcessService.add(financeApplyPlanProcess);
    }

    @ApiOperation(value = "删除财务用款计划申请流程")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return financeApplyPlanProcessService.delete(id);
    }

    @ApiOperation(value = "更新财务用款计划申请流程")
    @PutMapping()
    public int update(@RequestBody FinanceApplyPlanProcess financeApplyPlanProcess){
        return financeApplyPlanProcessService.updateData(financeApplyPlanProcess);
    }

    @ApiOperation(value = "查询财务用款计划申请流程分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<FinanceApplyPlanProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return financeApplyPlanProcessService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询财务用款计划申请流程")
    @GetMapping("{id}")
    public FinanceApplyPlanProcess findById(@PathVariable Long id){
        return financeApplyPlanProcessService.findById(id);
    }

}
