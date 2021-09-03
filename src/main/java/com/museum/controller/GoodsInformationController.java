package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.domain.GoodsInform;
import com.museum.service.IGoodsInputService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IGoodsInformationService;
import com.museum.domain.GoodsInformation;
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
 * 信息中心录入物品名称 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
@Api(tags = {"信息中心录入物品名称"})
@RestController
@RequestMapping("/goods-information")
public class GoodsInformationController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IGoodsInformationService goodsInformationService;

    @Resource
    private IGoodsInputService goodsInputService;


    @ApiOperation(value = "新增信息中心录入物品名称")
    @PostMapping()
    public int add(@RequestBody GoodsInformation goodsInformation){
        goodsInformation.setCreatetimes(SystemDateUtils.getStrDate());
        return goodsInformationService.add(goodsInformation);
    }

    @ApiOperation(value = "删除信息中心录入物品名称")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return goodsInformationService.delete(id);
    }

    @ApiOperation(value = "更新信息中心录入物品名称")
    @PutMapping()
    public int update(@RequestBody GoodsInformation goodsInformation){
        return goodsInformationService.updateData(goodsInformation);
    }

    @ApiOperation(value = "查询信息中心录入物品名称分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<GoodsInformation> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return goodsInformationService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "录入物品")
    @GetMapping("/findByList")
    public List<GoodsInformation> findById(String type){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("goods_type",type);
        return goodsInformationService.list(queryWrapper);
    }

    @ApiOperation(value = "设备总数量")
    @GetMapping("/gettotal")
    public Double gettotal(){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("goods_type","固产");
        GoodsInformation gs=goodsInformationService.getOne(queryWrapper);

        QueryWrapper queryWrappers  = new QueryWrapper();
        queryWrappers.eq("goods_type","耗材");
        GoodsInformation gs1=goodsInformationService.getOne(queryWrappers);
        Double dos=gs.getGoodsSum()+gs1.getGoodsSum();
        return dos;
    }

    @ApiOperation(value = "固产数量")
    @GetMapping("/getguchantotal")
    public Double getguchantotal(){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("goods_type","固产");
        GoodsInformation gs=goodsInformationService.getOne(queryWrapper);
        return gs.getGoodsSum();
    }

    @ApiOperation(value = "耗材")
    @GetMapping("/gethaocaitotal")
    public Double gethaocaitotal(){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("goods_type","耗材");
        GoodsInformation gs=goodsInformationService.getOne(queryWrapper);
        return gs.getGoodsSum();
    }

}
