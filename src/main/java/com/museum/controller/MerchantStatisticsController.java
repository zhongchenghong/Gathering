package com.museum.controller;

import com.museum.domain.JLProportion;
import com.museum.domain.JlCount;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IMerchantStatisticsService;
import com.museum.domain.MerchantStatistics;
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
 * 锦里商户统计、商户列表 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
@Api(tags = {"锦里公司----商户统计、商户列表"})
@RestController
@RequestMapping("/merchant-statistics")
public class MerchantStatisticsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMerchantStatisticsService merchantStatisticsService;


    @ApiOperation(value = "新增锦里商户统计、商户列表")
    @PostMapping()
    public int add(@RequestBody MerchantStatistics merchantStatistics){
        return merchantStatisticsService.add(merchantStatistics);
    }

    @ApiOperation(value = "删除锦里商户统计、商户列表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return merchantStatisticsService.delete(id);
    }

    @ApiOperation(value = "更新锦里商户统计、商户列表")
    @PutMapping()
    public int update(@RequestBody MerchantStatistics merchantStatistics){
        return merchantStatisticsService.updateData(merchantStatistics);
    }

    @ApiOperation(value = "查询锦里商户统计、商户列表分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<MerchantStatistics> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return merchantStatisticsService.findListByPage(page, pageCount);
    }


    @ApiOperation(value = "商户统计")
    @GetMapping("/bycount")
    public List<JlCount> findById(){
        return merchantStatisticsService.bycount();
    }

    @ApiOperation(value = "商户（分类别）总交易金额占比")
    @GetMapping("/bytypescount")
    public List<JLProportion> byTypesCount(){
        return merchantStatisticsService.byTypesCount();
    }

}
