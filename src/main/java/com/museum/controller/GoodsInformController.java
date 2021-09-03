package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.domain.*;
import com.museum.service.IAccountService;
import com.museum.service.IAgentService;
import com.museum.service.IGoodsFormMessageService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IGoodsInformService;
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
 * 物品领用 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Api(tags = {"信息中心物品领用"})
@RestController
@RequestMapping("/goods-inform")
public class GoodsInformController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IGoodsInformService goodsInformService;

    @Resource
    private IGoodsFormMessageService goodsFormMessageService;

    @Resource
    private IAccountService accountService;

    @Resource
    private IAgentService agentService;


    @ApiOperation(value = "新增物品领用")
    @PostMapping("/add")
    public Result add(@RequestBody GoodsInformList goodsInform, HttpServletRequest req){
        GoodsInform gif= new GoodsInform();
        QueryWrapper queryWrappet  = new QueryWrapper();
        Account acc=accountService.findAccount(req);
        String str=SystemDateUtils.getStrDate();
            gif.setCreatetimes(str);
            gif.setUid(acc.getId());
            gif.setClaimName(goodsInform.getClaimName());
            gif.setClaimTime(goodsInform.getClaimTime());
            gif.setGoodsInformationId(goodsInform.getGoodsInformationId());
            gif.setRemarks(goodsInform.getRemarks());
            gif.setType(goodsInform.getType()+"");
            gif.setState(0);
            goodsInformService.add(gif);
            queryWrappet.eq("createtimes",str);
            queryWrappet.eq("uid",acc.getId());
            GoodsInform  goodsInforms=goodsInformService.getOne(queryWrappet);
        for (int i=0;i<goodsInform.getStr().size();i++){
            GoodsFormMessage goodsFormMessage = new  GoodsFormMessage();
            goodsInform.getStr().get(i).setGoodsInformId(goodsInforms.getId());
            goodsFormMessage.setCreatetimes(str);
            goodsFormMessageService.add(goodsFormMessage);
        }

        //获取部门主任
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("department_id",2);
        queryWrapper.eq("position_id",3);
        Account ac=accountService.getOne(queryWrapper);

        //添加到待办部门主任待办事项
        Agent ag = new Agent();
        ag.setUid(acc.getAgencyUid());
        ag.setCreatetimes(SystemDateUtils.getStrDate());
        if(goodsInform.getType()==1){
            ag.setTitles("固产物品申请");
        }else{
            ag.setTitles("耗材物品申请");
        }
        ag.setAgentType(11);
        ag.setImageDataId(goodsInforms.getId());
        ag.setState(2);
        ag.setSubmitid(ac.getId());
        agentService.save(ag);
        return ResultUtil.success();
    }


    @ApiOperation(value = "物品领用审批")
    @PostMapping("/trial")
    public Result trial( HttpServletRequest req,Long id,int state){

        Agent ag=agentService.findById(id);
        GoodsInform gif=goodsInformService.findById(ag.getImageDataId().longValue());
        gif.setState(state);
        goodsInformService.updateById(gif);
        ag.setState(state);
        //获取部门主任
        agentService.updateById(ag);
        return ResultUtil.success();
    }

    @ApiOperation(value = "删除物品领用")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return goodsInformService.delete(id);
    }

    @ApiOperation(value = "更新物品领用")
    @PutMapping()
    public int update(@RequestBody GoodsInform goodsInform){
        return goodsInformService.updateData(goodsInform);
    }

    @ApiOperation(value = "查询物品领用分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<GoodsInform> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return goodsInformService.findListByPage(page, pageCount);
    }



}
