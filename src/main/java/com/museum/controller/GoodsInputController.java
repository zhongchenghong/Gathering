package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.domain.*;
import com.museum.service.IGoodsInformationService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IGoodsInputService;
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
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
@Api(tags = {"信息中心物品录入"})
@RestController
@RequestMapping("/goods-input")
public class GoodsInputController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IGoodsInputService goodsInputService;

    @Resource
    private IGoodsInformationService goodsInformationService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public Result add(@RequestBody GoodsInputList goodsInputList){
        GoodsInput goodsInput = new GoodsInput();
        for (int i = 0; i < goodsInputList.getLs().size(); i++) {

                goodsInput.setInserttime(goodsInputList.getInserttime());
                goodsInput.setInsertname(goodsInputList.getInsertname());
                goodsInput.setCreatetimes(SystemDateUtils.getStrDate());
                goodsInput.setRemarks(goodsInputList.getRemarks());
                goodsInput.setClaimState(0);
                goodsInput.setGoodsid(goodsInputList.getLs().get(i).getId());
                goodsInput.setGoodsum(goodsInputList.getLs().get(i).getGoodsSum());
                goodsInputService.add(goodsInput);
                GoodsInformation goodsInformation =goodsInformationService.findById(goodsInputList.getLs().get(i).getId().longValue());
                goodsInformation.setGoodsSum(goodsInputList.getLs().get(i).getGoodsSum()+goodsInformation.getGoodsSum());
                goodsInformationService.updateData(goodsInformation);
        }
        return ResultUtil.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return goodsInputService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody GoodsInput goodsInput){
        return goodsInputService.updateData(goodsInput);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<GoodsInput> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String name){
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("goods_name",name);
        return goodsInputService.page(goodsInputService.findListByPage(page, pageCount),queryWrappet);
    }

/*
    @ApiOperation(value = "信息中心设备总数量")
    @GetMapping("/getcount")
    public int getcount(){
        return goodsInputService.totail();
    }

*/

    @ApiOperation(value = "信息中心固产耗材总数量")
    @PostMapping("/trial")
    @ResponseBody
    public Statistics trial(){
        Statistics st = new Statistics();
        String total= goodsInputService.totail();
        String guchan=goodsInputService.selectBytype("固产");
        String haocai=goodsInputService.selectBytype("耗材");
        if(total!=null&&!"".equals(total)){
            st.setTotal(total.split("\\.")[0]);
        }else{
            st.setTotal("0");
        }
        if(haocai!=null&&!"".equals(haocai)){
            st.setHaocai(haocai.split("\\.")[0]);
        }else{
            st.setHaocai("0");
        }

        if(guchan!=null&&!"".equals(guchan)){
            st.setGuchan(guchan.split("\\.")[0]);
        }else{
            st.setGuchan("0");
        }

        return st;
    }


}
