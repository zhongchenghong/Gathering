package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IOfficeGoodsInformationService;
import com.museum.domain.OfficeGoodsInformation;
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
 * 办公室录入物品名称 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-19
 */
@Api(tags = {"办公室录---入物品名称"})
@RestController
@RequestMapping("/office-goods-information")
public class OfficeGoodsInformationController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IOfficeGoodsInformationService officeGoodsInformationService;


    @ApiOperation(value = "新增办公室录入物品名称")
    @PostMapping()
    public int add(@RequestBody OfficeGoodsInformation officeGoodsInformation){

        return officeGoodsInformationService.add(officeGoodsInformation);
    }

    @ApiOperation(value = "删除办公室录入物品名称")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return officeGoodsInformationService.delete(id);
    }

    @ApiOperation(value = "更新办公室录入物品名称")
    @PutMapping()
    public int update(@RequestBody OfficeGoodsInformation officeGoodsInformation){
        return officeGoodsInformationService.updateData(officeGoodsInformation);
    }

    @ApiOperation(value = "查询办公室录入物品名称分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<OfficeGoodsInformation> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String goods_type,String goods_name){
        QueryWrapper queryWrapper  = new QueryWrapper();
        if(!"".equals(goods_type)&&goods_type!=null){
            queryWrapper.eq("goods_type",goods_type);
        }
        if(!"".equals(goods_name)&&goods_name!=null){
            queryWrapper.eq("goods_name",goods_name);
        }
        return officeGoodsInformationService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询办公室录入物品名称")
    @GetMapping("{id}")
    public OfficeGoodsInformation findById(@PathVariable Long id){
        return officeGoodsInformationService.findById(id);
    }


    @ApiOperation(value = "办公用品")
    @PostMapping("/getcount")
    public Double getcount(){
        Double count=0.0;
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("goods_type","办公用品");
        List<OfficeGoodsInformation> li = officeGoodsInformationService.list(queryWrapper);
        if(li!=null&&li.size()>0){
            for (int i=0;i<li.size();i++){
                count=count+li.get(i).getGoodsSum();
            }
        }
        return count;
    }

    @ApiOperation(value = "清洁用品")
    @PostMapping("/getqingjie")
    public Double getqingjie(){
        Double count=0.0;
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("goods_type","清洁用品");
        List<OfficeGoodsInformation> li = officeGoodsInformationService.list(queryWrapper);
        if(li!=null&&li.size()>0){
            for (int i=0;i<li.size();i++){
                count=count+li.get(i).getGoodsSum();
            }
        }
        return count;
    }

    @ApiOperation(value = "劳保用品")
    @PostMapping("/getlaobao")
    public Double getlaobao(){
        Double count=0.0;
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("goods_type","劳保用品");
        List<OfficeGoodsInformation> li = officeGoodsInformationService.list(queryWrapper);
        if(li!=null&&li.size()>0){
            for (int i=0;i<li.size();i++){
                count=count+li.get(i).getGoodsSum();
            }
        }
        return count;
    }

    @ApiOperation(value = "库存预警")
    @PostMapping("/getlist")
    public  List<OfficeGoodsInformation> getlist(){
        Double count=0.0;
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("goods_type","劳保用品");
        List<OfficeGoodsInformation> li = officeGoodsInformationService.list(queryWrapper);
        return li;
    }

    @ApiOperation(value = "出入库统计")
    @PostMapping("/getlists")
    public  List<OfficeGoodsInformation> getlists(){
        Double count=0.0;
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.groupBy("goods_type","劳保用品");
        queryWrapper.groupBy("createtimes");
        List<OfficeGoodsInformation> li = officeGoodsInformationService.list(queryWrapper);
        return li;
    }


}
