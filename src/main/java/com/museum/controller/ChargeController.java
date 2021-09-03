package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IChargeService;
import com.museum.domain.Charge;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 数据中心-电力符合数 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Api(tags = {"数据中心-电力符合数"})
@RestController
@RequestMapping("/charge")
public class ChargeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IChargeService chargeService;


    @ApiOperation(value = "新增数据中心-电力符合数")
    @PostMapping()
    public int add(@RequestBody Charge charge){
        charge.setCreatetimes(SystemDateUtils.getStrDate());
        return chargeService.add(charge);
    }

    @ApiOperation(value = "删除数据中心-电力符合数")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return chargeService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-电力符合数")
    @PutMapping()
    public int update(@RequestBody Charge charge){
        return chargeService.updateData(charge);
    }

    @ApiOperation(value = "查询数据中心-电力符合数分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Charge> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String num){
        QueryWrapper queryWrapper = new QueryWrapper();
        if(num!=null&&!"".equals(num)){
            queryWrapper.like("num",num);
        }
        queryWrapper.select("sum(load) as total");
        return chargeService.page(chargeService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询数据中心-电力符合数")
    @GetMapping("{id}")
    public Charge findById(@PathVariable Long id){
        return chargeService.findById(id);
    }

}
