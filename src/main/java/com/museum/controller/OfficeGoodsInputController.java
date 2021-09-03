package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.domain.*;
import com.museum.service.IOfficeGoodsInformationService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IOfficeGoodsInputService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 办公室物品录入 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-19
 */
@Api(tags = {"办公室物品录入"})
@RestController
@RequestMapping("/office-goods-input")
public class OfficeGoodsInputController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IOfficeGoodsInputService officeGoodsInputService;

    @Resource
    private IOfficeGoodsInformationService officeGoodsInformationService;



    @ApiOperation(value = "新增办公室物品录入")
    @PostMapping()
    public Result add(@RequestBody OfficeGoodsInputList officeGoodsInputList){
        OfficeGoodsInput goodsInput = new OfficeGoodsInput();
        for (int i = 0; i < officeGoodsInputList.getLs().size(); i++) {
            goodsInput.setInserttime(officeGoodsInputList.getInserttime());
            goodsInput.setInsertname(officeGoodsInputList.getInsertname());
            goodsInput.setCreatetimes(SystemDateUtils.getStrDate());
            goodsInput.setRemarks(officeGoodsInputList.getRemarks());
            goodsInput.setClaimState(1);
            goodsInput.setName(officeGoodsInputList.getLs().get(i).getGoodsName());
            goodsInput.setUnit(officeGoodsInputList.getLs().get(i).getUnit());
            goodsInput.setGoodsum(officeGoodsInputList.getLs().get(i).getGoodsSum());
            goodsInput.setGoodsid(officeGoodsInputList.getLs().get(i).getId());
            officeGoodsInputService.add(goodsInput);
            OfficeGoodsInformation goodsInformation =officeGoodsInformationService.findById(officeGoodsInputList.getLs().get(i).getId().longValue());
            goodsInformation.setGoodsSum(officeGoodsInputList.getLs().get(i).getGoodsSum()+goodsInformation.getGoodsSum());
            officeGoodsInformationService.updateData(goodsInformation);
        }
        return ResultUtil.success();
    }

    @ApiOperation(value = "办公室物品出库")
    @PostMapping("/reduce")
    public Result reduce(@RequestBody OfficeGoodsInputList officeGoodsInputList){
        OfficeGoodsInput goodsInput = new OfficeGoodsInput();
        for (int i = 0; i < officeGoodsInputList.getLs().size(); i++) {
            goodsInput.setInserttime(officeGoodsInputList.getInserttime());
            goodsInput.setInsertname(officeGoodsInputList.getInsertname());
            goodsInput.setCreatetimes(SystemDateUtils.getStrDate());
            goodsInput.setRemarks(officeGoodsInputList.getRemarks());
            goodsInput.setClaimState(0);
            goodsInput.setName(officeGoodsInputList.getLs().get(i).getGoodsName());
            goodsInput.setUnit(officeGoodsInputList.getLs().get(i).getUnit());
            goodsInput.setGoodsum(-officeGoodsInputList.getLs().get(i).getGoodsSum());
            goodsInput.setGoodsid(officeGoodsInputList.getLs().get(i).getId());
            officeGoodsInputService.add(goodsInput);
            OfficeGoodsInformation goodsInformation =officeGoodsInformationService.findById(officeGoodsInputList.getLs().get(i).getId().longValue());
            goodsInformation.setGoodsSum(officeGoodsInputList.getLs().get(i).getGoodsSum()-goodsInformation.getGoodsSum());
            officeGoodsInformationService.updateData(goodsInformation);
        }
        return ResultUtil.success();
    }

    @ApiOperation(value = "删除办公室物品录入")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return officeGoodsInputService.delete(id);
    }

    @ApiOperation(value = "更新办公室物品录入")
    @PutMapping()
    public int update(@RequestBody OfficeGoodsInput officeGoodsInput){
        return officeGoodsInputService.updateData(officeGoodsInput);
    }

    @ApiOperation(value = "查询办公室物品录入分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<OfficeGoodsInput> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String time,String type,String name){
            //queryWrapper.eq("userName",name);
        return officeGoodsInputService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询办公室物品录入")
    @GetMapping("{id}")
    public OfficeGoodsInput findById(@PathVariable Long id){
        return officeGoodsInputService.findById(id);
    }

}
