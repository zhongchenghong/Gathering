package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.domain.*;
import com.museum.service.*;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用款计划申请 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 */
@Api(tags = {"财务部-----用款计划申请"})
@RestController
@RequestMapping("/finance-apply-plan")
public class FinanceApplyPlanController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IFinanceApplyPlanService financeApplyPlanService;

    @Resource
    private IAccountService accountService;

    @Resource
    private IFinanceContentService financeContentService;

    @Resource
    private IFinanceApplyPlanProcessService financeApplyPlanProcessService;

    @Resource
    private IAgentService agentService;

    @Resource
    private IDepartmentService departmentService;

    @Resource
    private IProceduresService proceduresService;


    @ApiOperation(value = "新增用款计划申请")
    @PostMapping("/add")
    public Result add(FinanceApplyPlanContent financeApplyPlanContent, HttpServletRequest req){
       String str=SystemDateUtils.getStrDate();
        //添加表单
        Account ac=accountService.findAccount(req);
        FinanceApplyPlan financeApplyPlan= new FinanceApplyPlan();
        financeApplyPlan.setApplicationTime(financeApplyPlanContent.getApplicationTime());
        financeApplyPlan.setDepartmentName(financeApplyPlanContent.getDepartmentName());
        financeApplyPlan.setCreatetimes(str);
        financeApplyPlan.setUid(ac.getId());
        financeApplyPlan.setMoney(financeApplyPlanContent.getMoney());
        financeApplyPlanService.add(financeApplyPlan);

        //添加申报内容
        QueryWrapper queryWrapperw = new QueryWrapper();
        queryWrapperw.eq("createtimes", str);
        queryWrapperw.eq("application_time", financeApplyPlanContent.getApplicationTime());
        FinanceApplyPlan financeApplyPlans=financeApplyPlanService.getOne(queryWrapperw);
        for(FinanceContent fc:financeApplyPlanContent.getFinanceContent()){
            fc.setParentId(financeApplyPlans.getId());
            financeContentService.add(fc);
        }


        try {
            //获取部门主任
            QueryWrapper queryWrapper  = new QueryWrapper();
            queryWrapper.eq("department_id",ac.getDepartmentId());
            queryWrapper.eq("position_id",3);
            Account acc=accountService.getOne(queryWrapper);

            FinanceApplyPlanProcess financeApplyPlanProcess = new FinanceApplyPlanProcess();
            //判断是否开启待办转交,1为转交
            if(acc.getAgencyState()==1){
                //给代办人添加到业务流程
                financeApplyPlanProcess.setUid(ac.getId());
                financeApplyPlanProcess.setDepartmentDirectorState(2);
                financeApplyPlanProcess.setDepartmentDirectorId(acc.getAgencyUid());
                //表单id
                financeApplyPlanProcess.setImageDataid(financeApplyPlans.getId());
                financeApplyPlanProcess.setDirectorconsultId(acc.getId());
                financeApplyPlanProcess.setCreateTime(SystemDateUtils.getStrDate());
                financeApplyPlanProcess.setTitle("用款计划申请");
                financeApplyPlanProcessService.add(financeApplyPlanProcess);

                //添加到待办部门主任待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getAgencyUid());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("用款计划申请");
                ag.setAgentType(10);
                ag.setImageDataId(financeApplyPlans.getId());
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);

            }else {
                //添加到主任的待办流程
                financeApplyPlanProcess.setUid(ac.getId());
                financeApplyPlanProcess.setDepartmentDirectorState(2);
                financeApplyPlanProcess.setDepartmentDirectorId(acc.getId());
                financeApplyPlanProcess.setImageDataid(financeApplyPlans.getId());
                financeApplyPlanProcess.setCreateTime(SystemDateUtils.getStrDate());
                financeApplyPlanProcess.setTitle("用款计划申请");
                financeApplyPlanProcessService.add(financeApplyPlanProcess);

                //添加到部门主任待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getId());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("用款计划申请");
                ag.setAgentType(10);
                ag.setImageDataId(financeApplyPlans.getId());
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);
            }


            //添加到我的流程
            Procedures pc= new Procedures();
            pc.setApplyTime(SystemDateUtils.getStrDate());
            pc.setApplyType("用款计划申请");
            pc.setApplyTypeid(8);
            pc.setState(2);
            pc.setPname(ac.getName());

            pc.setProcessId(financeApplyPlans.getId());
            if(acc.getAgencyState()==1){
                pc.setRoles(acc.getAgencyUid());
                Account aa= accountService.findById(Long.valueOf(acc.getAgencyUid()));
                Department de=departmentService.findById(Long.valueOf(acc.getDepartmentId()));
                pc.setProcessName(de.getDepartmentName()+"["+aa.getName()+"]");
                pc.setUid(acc.getAgencyUid());
            }else{
                pc.setRoles(acc.getId());
                Department de=departmentService.findById(Long.valueOf(acc.getDepartmentId()));
                pc.setProcessName(de.getDepartmentName()+"["+acc.getName()+"]");
                pc.setUid(acc.getId());
            }
            proceduresService.save(pc);
            return   ResultUtil.success();

        }catch (Exception e){
            e.printStackTrace();
            return   ResultUtil.error(401,"申请提交失败");
        }

    }


    /**
     *
     * @param id 待办事项image_data_id
     * @param state
     * @param req
     * @return
     */
    @ApiOperation(value = "部门主任审核")
    @PostMapping("/examination")
    public Result examination(int id,int state,HttpServletRequest req,FinanceApplyPlan financeApplyPlan,String director_idea){
        //主任申请资料编辑审核
        financeApplyPlanService.updateById(financeApplyPlan);
        int zid;
        try {

            //获取本部门主任id
            Account acc=accountService.findAccount(req);
            //通过id，修改审核状态,和意见
            FinanceApplyPlanProcess financeApplyPlanProcess = new  FinanceApplyPlanProcess();
            financeApplyPlanProcess.setDepartmentDirectorState(state);
            financeApplyPlanProcess.setDirectorRemarks(director_idea);
            QueryWrapper queryWra  = new QueryWrapper();
            queryWra.eq("image_dataId",id);
            financeApplyPlanProcessService.update(financeApplyPlanProcess,queryWra);

            //待办主任事项完成
            QueryWrapper queryWrappers  = new QueryWrapper();
            queryWrappers.eq("image_data_id",id);
            queryWrappers.eq("uid",acc.getId());
            Agent agg=agentService.getOne(queryWrappers);
            agg.setState(state);
            agentService.updateById(agg);
            Procedures pc= new Procedures();
            //部门主任审核通过，移交给财务主任，如果财务主任开启待办移交，移交给副主任。
            if(state==0){
                //财务主任
                QueryWrapper queryWrappere  = new QueryWrapper();
                queryWrappere.eq("department_id",5);
                queryWrappere.eq("position_id",3);
                Account a=accountService.getOne(queryWrappere);
                QueryWrapper queryWrapperc  = new QueryWrapper();
                //开启待办
                if(a!=null&&a.getAgencyState()==1){
                    queryWrapperc.eq("image_dataId",id);
                    financeApplyPlanProcess.setInformationCenter(a.getAgencyUid());
                    financeApplyPlanProcess.setInformationCenterState(2);
                    financeApplyPlanProcess.setCenterconsultId(a.getId());
                    financeApplyPlanProcess.setDepartmentDirectorTime(SystemDateUtils.getDaDate());
                    financeApplyPlanProcessService.update(financeApplyPlanProcess,queryWrapperc);


                    //添加到财务主任待办人的待办事项事项
                    Agent age = new Agent();
                    age.setUid(a.getAgencyUid());
                    age.setCreatetimes(SystemDateUtils.getStrDate());
                    age.setTitles("用款计划申请");
                    age.setAgentType(10);
                    age.setImageDataId(id);
                    age.setState(2);
                    age.setSubmitid(acc.getId());
                    agentService.save(age);
                    zid=a.getAgencyUid();
                }else{
                    queryWrapperc.eq("image_dataId",id);
                    financeApplyPlanProcess.setInformationCenter(a.getId());
                    financeApplyPlanProcess.setInformationCenterState(2);
                    financeApplyPlanProcess.setDepartmentDirectorTime(SystemDateUtils.getDaDate());
                    financeApplyPlanProcessService.update(financeApplyPlanProcess,queryWrapperc);

                    //添加到财务主任的待办事项
                    Agent age = new Agent();
                    age.setUid(a.getId());
                    age.setCreatetimes(SystemDateUtils.getStrDate());
                    age.setTitles("用款计划申请");
                    age.setAgentType(10);
                    age.setImageDataId(id);
                    age.setState(2);
                    age.setSubmitid(acc.getId());
                    agentService.save(age);
                    zid=a.getId();
                }

                //通过,修改我的流程
                QueryWrapper queryWrapp  = new QueryWrapper();
                queryWrapp.eq("process_id",id);
                pc.setState(0);
                Account acco=accountService.findById(Long.valueOf(zid));
                Department de=departmentService.findById(Long.valueOf(acco.getDepartmentId()));
                pc.setProcessName(de.getDepartmentName()+"["+acco.getName()+"]");
                proceduresService.update(pc,queryWrapp);
            }else{

                //未通过,修改我的流程
                QueryWrapper queryWrapp  = new QueryWrapper();
                queryWrapp.eq("process_id",id);
                pc.setState(1);
                proceduresService.update(pc,queryWrapp);
            }

            return   ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return   ResultUtil.error(401,"出现未知错误");
        }

    }


    /**
     *
     * @param id 待办事项 image_data_id
     * @param state 待办事项
     * @param req
     * @param grantId
     */
    @ApiOperation(value = "财务主任审核")
    @PostMapping("/center")
    public void center( int id,int state,HttpServletRequest req,int grantId,String centerIdea){
        Procedures pc= new Procedures();
        try {
            QueryWrapper queryWrapp  = new QueryWrapper();
            queryWrapp.eq("image_dataId",id);
            Account ac=accountService.findAccount(req);
            FinanceApplyPlanProcess financeApplyPlanProcess = new  FinanceApplyPlanProcess();
            financeApplyPlanProcess.setInformationCenterTime(SystemDateUtils.getDaDate());
            financeApplyPlanProcess.setDirectorRemarks(centerIdea);
            financeApplyPlanProcess.setInformationCenterState(state);
            financeApplyPlanProcess.setGrantId(grantId);
            financeApplyPlanProcessService.update(financeApplyPlanProcess,queryWrapp);
            //修改主任待办状态
            QueryWrapper queryWrapps  = new QueryWrapper();
            queryWrapps.eq("image_data_id",id);
            queryWrapps.eq("uid",ac.getId());
            Agent age = new Agent();
            age.setState(0);
            agentService.update(age,queryWrapps);

            //通过,修改我的流程
            QueryWrapper queryWrap  = new QueryWrapper();
            queryWrap.eq("process_id",id);
            pc.setState(3);
            Account acco=accountService.findById(Long.valueOf(grantId));
            Department de=departmentService.findById(Long.valueOf(acco.getDepartmentId()));
            pc.setProcessName(de.getDepartmentName()+"["+acco.getName()+"]");
            proceduresService.update(pc,queryWrap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "删除用款计划申请")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return financeApplyPlanService.delete(id);
    }

    @ApiOperation(value = "更新用款计划申请")
    @PutMapping()
    public int update(@RequestBody FinanceApplyPlan financeApplyPlan){
        return financeApplyPlanService.updateData(financeApplyPlan);
    }

    @ApiOperation(value = "查询用款计划申请分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<FinanceApplyPlan> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String department_name,String endTime,String startTime){
        QueryWrapper queryWrap  = new QueryWrapper();
        if(!"".equals(department_name)&&department_name!=null){
            queryWrap.eq("department_name",department_name);
        }
        if(!"".equals(endTime)&&endTime!=null&&!"".equals(startTime)&&startTime!=null){
            queryWrap.ge("createtimes",startTime);
            queryWrap.le("createtimes",endTime);

        }

        return financeApplyPlanService.page(financeApplyPlanService.findListByPage(page, pageCount),queryWrap);
    }

    @ApiOperation(value = "id查询用款计划申请")
    @GetMapping("{id}")
    public FinanceApplyPlan findById(@PathVariable Long id){
        return financeApplyPlanService.findById(id);
    }

}
