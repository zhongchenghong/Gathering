package com.museum.controller;

import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.service.IRiskService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IInsuranceService;
import com.museum.domain.Insurance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 办公室车辆保险 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Api(tags = {"办公室车辆保险"})
@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IInsuranceService insuranceService;

    @Resource
    private IAccountService accountService;

    @Resource
    private IRiskService riskService;


    @ApiOperation(value = "新增办公室车辆保险")
    @PostMapping()
    public int add(@RequestBody Insurance insurance, HttpServletRequest req){
        Account acc=accountService.findAccount(req);
        insurance.setUid(acc.getId());
        insurance.setCreatetimes(SystemDateUtils.getStrDate());
        return insuranceService.add(insurance);
    }

    @ApiOperation(value = "删除办公室车辆保险")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return insuranceService.delete(id);
    }

    @ApiOperation(value = "更新办公室车辆保险")
    @PutMapping()
    public int update(@RequestBody Insurance insurance){
        return insuranceService.updateData(insurance);
    }

    @ApiOperation(value = "查询办公室车辆保险分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Insurance> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return insuranceService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询办公室车辆保险")
    @GetMapping("{id}")
    public Insurance findById(@PathVariable Long id){
        return insuranceService.findById(id);
    }

}
