package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.domain.GroupByMonth;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IProductIncomeService;
import com.museum.domain.ProductIncome;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 文化公司产品收入 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Api(tags = {"文化公司产品收入"})
@RestController
@RequestMapping("/product-income")
public class ProductIncomeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IProductIncomeService productIncomeService;


    @ApiOperation(value = "新增文化公司产品收入")
    @PostMapping()
    public int add(@RequestBody ProductIncome productIncome){
        return productIncomeService.add(productIncome);
    }

    @ApiOperation(value = "删除文化公司产品收入")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return productIncomeService.delete(id);
    }

    @ApiOperation(value = "更新文化公司产品收入")
    @PutMapping()
    public int update(@RequestBody ProductIncome productIncome){
        return productIncomeService.updateData(productIncome);
    }

    @ApiOperation(value = "查询文化公司产品收入分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ProductIncome> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String type){
        QueryWrapper queryWrapper  = new QueryWrapper();
        if(type!=null&&!"".equals(type)){
            queryWrapper.like("type",type);
        }
        return productIncomeService.page(productIncomeService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询文化公司产品收入")
    @GetMapping("{id}")
    public ProductIncome findById(@PathVariable Long id){
        return productIncomeService.findById(id);
    }

    @ApiOperation(value = "获取文化公司月统计数据")
    @PostMapping("/getcountByMonth")
    public List<GroupByMonth> getcountByMonth(String type){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return productIncomeService.getmoneyByMonth( sdf.format(date),type);
    }

}
