package com.museum.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.Agent;
import com.museum.service.IAccountService;
import com.museum.service.IAgentService;
import com.museum.util.DateUtil;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IMissionPlanService;
import com.museum.domain.MissionPlan;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.museum.util.DateUtil.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-02
 */
@Api(tags = {"通用功能----日程安排"})
@RestController
@RequestMapping("/mission-plan")
public class MissionPlanController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMissionPlanService missionPlanService;
    @Resource
    private IAccountService accountService;

    @Resource
    private IAgentService agentService;


    @ApiOperation(value = "新增日程安排")
    @PostMapping()
    public int add(@RequestBody MissionPlan missionPlan,HttpServletRequest req){
        String date=SystemDateUtils.getStrDateymd();
        missionPlan.setCreatetimes(date);
        missionPlan.setPlanstate(0);
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=accountService.getOne(queryWrapper);
        missionPlan.setUid(bo.getId());
        return missionPlanService.add(missionPlan);
    }

    @ApiOperation(value = "删除日程安排")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return missionPlanService.delete(id);
    }

    @ApiOperation(value = "修改日程安排")
    @PutMapping()
    public Boolean update(@RequestBody MissionPlan missionPlan){
        return missionPlanService.updateById(missionPlan);
    }


    @ApiOperation(value = "查询日程")
    @GetMapping("/findListBytime")
    public List<MissionPlan> findListBytime(String  dates, int type, HttpServletRequest req){

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //获取天
        String startDayTime = DateUtil.toStr(null, getDayStartTime(date));
        String endDayTime=DateUtil.toStr(null, getDayEndTime(date));
        //获取周
        String startWeekTime=DateUtil.toStr(null, getWeekStartTime(date));
        String endWeekTime=DateUtil.toStr(null,getWeekEndTime(date));
        //获取月
        String startMonthTime=DateUtil.toStr(null, getMonthStartTime(date));
        String endMonthTime=DateUtil.toStr(null, getMonthEndTime(date));


        //获取当前登录人
        Account acc=accountService.findAccount(req);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("uid",acc.getId());

        //获取当天的日程
            if(type==0){
                if(!"".equals(startDayTime)&&null!=startDayTime){
                    queryWrapper .apply(StrUtil.isNotBlank(startDayTime),
                            "date_format (createtimes,'%Y-%m-%d') >= date_format('" + startDayTime + "','%Y-%m-%d')");
                }
                if(!"".equals(endDayTime)&&null!=endDayTime){
                    queryWrapper.apply(StrUtil.isNotBlank(endDayTime),
                            "date_format (createtimes,'%Y-%m-%d') <= date_format('" + endDayTime + "','%Y-%m-%d')");
                }

        }

        //获取本周的日程
        if(type==1){
            if(!"".equals(startWeekTime)&&null!=startWeekTime){
                queryWrapper .apply(StrUtil.isNotBlank(startWeekTime),
                        "date_format (createtimes,'%Y-%m-%d') >= date_format('" + startWeekTime + "','%Y-%m-%d')");
            }
            if(!"".equals(endMonthTime)&&null!=endMonthTime){
                queryWrapper.apply(StrUtil.isNotBlank(endMonthTime),
                        "date_format (createtimes,'%Y-%m-%d') <= date_format('" + endMonthTime + "','%Y-%m-%d')");
            }

        }

        //获取月的日程
        if(type==2){
            if(!"".equals(startMonthTime)&&null!=startMonthTime){
                queryWrapper .apply(StrUtil.isNotBlank(startMonthTime),
                        "date_format (createtimes,'%Y-%m-%d') >= date_format('" + startMonthTime + "','%Y-%m-%d')");
            }
            if(!"".equals(endMonthTime)&&null!=endMonthTime){
                queryWrapper.apply(StrUtil.isNotBlank(endMonthTime),
                        "date_format (createtimes,'%Y-%m-%d') <= date_format('" + endMonthTime + "','%Y-%m-%d')");
            }

        }
        return missionPlanService.list(queryWrapper);

    }

   /* @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public MissionPlan findById(@PathVariable Long id){
        return missionPlanService.findById(id);
    }

    @ApiOperation(value = "日程标记，完成或未完成")
    @GetMapping("/sign")
    public int sign(@PathVariable Long id){
        MissionPlan mp=missionPlanService.findById(id);
        mp.setPlanstate(1);
        //待办事项完成
        if(mp.getSynchronizeds()==1){
            QueryWrapper queryWrappers  = new QueryWrapper();
            queryWrappers.eq("mission_plan_id",mp.getId());
            Agent agg=agentService.getOne(queryWrappers);
            agg.setState(0);
            agentService.updateById(agg);
        }

        return missionPlanService.updateData(mp);
    }

    @ApiOperation(value = "查询完成后的日程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/signlast")
    public IPage<MissionPlan> signlast(@RequestParam Integer page,
                        @RequestParam Integer pageCount,HttpServletRequest req){
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrappers  = new QueryWrapper();
        queryWrappers.eq("userName",name);
        Account bo=accountService.getOne(queryWrappers);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("uid",bo.getId());
        queryWrapper.eq("planstate",1);
        queryWrapper.orderByDesc("createtimes");
        return missionPlanService.page(missionPlanService.findListByPage(page, pageCount),queryWrapper);
    }*/



}
