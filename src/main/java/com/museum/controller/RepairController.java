package com.museum.controller;

import com.museum.domain.Account;
import com.museum.service.IAccountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IRepairService;
import com.museum.domain.Repair;
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
 * 办公室维保登记 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Api(tags = {"办公室维保登记"})
@RestController
@RequestMapping("/repair")
public class RepairController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRepairService repairService;
    @Resource
    private IAccountService accountService;

    @ApiOperation(value = "新增办公室维保登记")
    @PostMapping()
    public int add(@RequestBody Repair repair, HttpServletRequest req){
        Account acc=accountService.findAccount(req);
        repair.setUid(acc.getId());
        return repairService.add(repair);
    }

    @ApiOperation(value = "删除办公室维保登记")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return repairService.delete(id);
    }

    @ApiOperation(value = "更新办公室维保登记")
    @PutMapping()
    public int update(@RequestBody Repair repair){
        return repairService.updateData(repair);
    }

    @ApiOperation(value = "查询办公室维保登记分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Repair> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return repairService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询办公室维保登记")
    @GetMapping("{id}")
    public Repair findById(@PathVariable Long id){
        return repairService.findById(id);
    }

}
