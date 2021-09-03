package com.museum.controller;

import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ISecurityCheckService;
import com.museum.domain.SecurityCheck;
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
 * 锦里公司安全记录检查表 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Api(tags = {"锦里公司安全记录检查表"})
@RestController
@RequestMapping("/security-check")
public class SecurityCheckController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ISecurityCheckService securityCheckService;

    @Resource
    private IAccountService accountService;


    @ApiOperation(value = "新增锦里公司安全记录检查表")
    @PostMapping()
    public int add(@RequestBody SecurityCheck securityCheck, HttpServletRequest req){
        Account ac=accountService.findAccount(req);
        securityCheck.setUid(ac.getId());
        securityCheck.setCreatetimes(SystemDateUtils.getStrDate());
        return securityCheckService.add(securityCheck);
    }

    @ApiOperation(value = "删除锦里公司安全记录检查表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return securityCheckService.delete(id);
    }

    @ApiOperation(value = "更新锦里公司安全记录检查表")
    @PutMapping()
    public int update(@RequestBody SecurityCheck securityCheck){
        return securityCheckService.updateData(securityCheck);
    }

    @ApiOperation(value = "查询锦里公司安全记录检查表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<SecurityCheck> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return securityCheckService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询锦里公司安全记录检查表")
    @GetMapping("{id}")
    public SecurityCheck findById(@PathVariable Long id){
        return securityCheckService.findById(id);
    }

}
