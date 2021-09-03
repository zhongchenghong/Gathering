

package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.domain.*;
import com.museum.service.*;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-26
 */


@Api(tags = {"信息中心---档案借阅"})
@RestController
@RequestMapping("/borrow-form")
public class BorrowFormController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBorrowFormService borrowFormService;

    @Resource
    private IAccountService accountService;

    @Resource
    private IProceduresService proceduresService;

    @Resource
    private IAgentService agentService;

    @Resource
    private IDepartmentService departmentService;

    @Resource
    private IBorrowProcessService borrowProcessService;

    @Resource
    private IBranchlibraryService branchlibraryService;


    @ApiOperation(value = "提交档案借阅申请单")
    @PostMapping()
    public Result add(@RequestBody BorrowForm borrowForm, HttpServletRequest req){
        String str= SystemDateUtils.getStrDate();
        borrowForm.setCreatetime(str);
        //添加表单
        Account ac=accountService.findAccount(req);
        borrowForm.setUid(ac.getId());
        borrowFormService.add(borrowForm);

        //获取刚上传的资料
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("createTime",str);
        queryWrappet.eq("uid",ac.getId());
        BorrowForm imd=borrowFormService.getOne(queryWrappet);
        int id=imd.getId();
        try {
            //获取部门主任
            QueryWrapper queryWrapper  = new QueryWrapper();
            queryWrapper.eq("department_id",ac.getDepartmentId());
            queryWrapper.eq("position_id",3);
            Account acc=accountService.getOne(queryWrapper);
            BorrowProcess borrowProcess = new  BorrowProcess();
            QueryWrapper queryW  = new QueryWrapper();
            queryW.eq("image_dataId",id);

            //判断是否开启待办转交,1为转交
            if(acc.getAgencyState()==1){
                //给代办人添加到业务流程
                borrowProcess.setUid(ac.getId());
                borrowProcess.setDepartmentDirectorState(2);
                borrowProcess.setDepartmentDirectorId(acc.getAgencyUid());
                borrowProcess.setImageDataid(id);
                borrowProcess.setDirectorconsultId(acc.getId());
                borrowProcess.setCreateTime(SystemDateUtils.getStrDate());
                borrowProcess.setTitle("档案借阅申请单");
                borrowProcessService.add(borrowProcess);
                //添加到待办部门主任待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getAgencyUid());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("档案借阅申请单");
                ag.setAgentType(9);
                ag.setImageDataId(id);
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);

            }else {
                //添加到主任的待办流程
                borrowProcess.setUid(ac.getId());
                borrowProcess.setDepartmentDirectorState(2);
                borrowProcess.setDepartmentDirectorId(acc.getId());
                borrowProcess.setImageDataid(id);
                borrowProcess.setCreateTime(SystemDateUtils.getStrDate());
                borrowProcess.setTitle("档案借阅申请单");
                borrowProcessService.add(borrowProcess);

                //添加到部门主任待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getId());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("档案借阅申请单");
                ag.setAgentType(9);
                ag.setImageDataId(id);
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);
            }


            //添加到我的流程
            Procedures pc= new Procedures();
            pc.setApplyTime(SystemDateUtils.getStrDate());
            pc.setApplyType("档案借阅申请单");
            pc.setApplyTypeid(7);
            pc.setState(2);
            pc.setPname(ac.getName());

            pc.setProcessId(id);
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
    public Result examination(int id,int state,HttpServletRequest req,BorrowForm borrowForm,String director_idea){
        //主任申请资料编辑审核
        borrowFormService.updateById(borrowForm);
        int zid;
        try {
            //获取本部门主任id
            Account acc=accountService.findAccount(req);
            //通过id，修改审核状态,和意见
            BorrowProcess borrowProcess = new  BorrowProcess();
            borrowProcess.setDepartmentDirectorState(state);
            borrowProcess.setDirectorRemarks(director_idea);
            QueryWrapper queryWra  = new QueryWrapper();
            queryWra.eq("image_dataId",id);
            borrowProcessService.update(borrowProcess,queryWra);

            //待办主任事项完成
            QueryWrapper queryWrappers  = new QueryWrapper();
            queryWrappers.eq("image_data_id",id);
            queryWrappers.eq("uid",acc.getId());
            Agent agg=agentService.getOne(queryWrappers);
            agg.setState(state);
            agentService.updateById(agg);
            Procedures pc= new Procedures();
            //部门主任审核通过，移交给信息中心主任，如果信息中心主任开启待办移交，移交给副主任。
            if(state==0){

                //获取部门分管领导
                QueryWrapper queryWrappere  = new QueryWrapper();
                queryWrappere.eq("departmentId",acc.getDepartmentId());
                Branchlibrary branchlibrary=branchlibraryService.getOne(queryWrappere);
                if(branchlibrary==null||"".equals(branchlibrary)){
                    return  ResultUtil.error(401,"部门馆长为空");
                }
                Account a=accountService.findById(branchlibrary.getUid().longValue());
                QueryWrapper queryWrapperc  = new QueryWrapper();
                //开启待办
                if(a!=null&&a.getAgencyState()==1){
                    queryWrapperc.eq("image_dataId",id);
                    borrowProcess.setInformationCenter(a.getAgencyUid());
                    borrowProcess.setInformationCenterState(2);
                    borrowProcess.setCenterconsultId(a.getId());
                    borrowProcess.setDepartmentDirectorTime(SystemDateUtils.getDaDate());
                    borrowProcessService.update(borrowProcess,queryWrapperc);


                    //添加到部门分管领导的待办事项
                    Agent age = new Agent();
                    age.setUid(a.getAgencyUid());
                    age.setCreatetimes(SystemDateUtils.getStrDate());
                    age.setTitles("档案借阅申请单");
                    age.setAgentType(9);
                    age.setImageDataId(id);
                    age.setState(2);
                    age.setSubmitid(acc.getId());
                    agentService.save(age);
                    zid=a.getAgencyUid();
                }else{
                    queryWrapperc.eq("image_dataId",id);
                    borrowProcess.setInformationCenter(a.getId());
                    borrowProcess.setInformationCenterState(2);
                    borrowProcess.setDepartmentDirectorTime(SystemDateUtils.getDaDate());
                    borrowProcessService.update(borrowProcess,queryWrapperc);

                    //添加到部门分管领导的待办事项
                    Agent age = new Agent();
                    age.setUid(a.getId());
                    age.setCreatetimes(SystemDateUtils.getStrDate());
                    age.setTitles("档案借阅申请单");
                    age.setAgentType(9);
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
     *
     */


    @ApiOperation(value = "部门分馆领导审核")
    @PostMapping("/center")
    public Result center( int id,int state,HttpServletRequest req,BorrowForm borrowForm,String director_idea){
        //部门分馆申请资料编辑
        borrowFormService.updateById(borrowForm);
        int zid;
        try {
            //获取部门分馆id
            Account acc=accountService.findAccount(req);
            //通过id，修改审核状态,和意见
            BorrowProcess borrowProcess = new  BorrowProcess();
            borrowProcess.setDepartmentDirectorState(state);
            borrowProcess.setCenterRemarks(director_idea);
            QueryWrapper queryWra  = new QueryWrapper();
            queryWra.eq("image_dataId",id);
            borrowProcessService.update(borrowProcess,queryWra);

            //待办部门分馆事项完成
            QueryWrapper queryWrappers  = new QueryWrapper();
            queryWrappers.eq("image_data_id",id);
            queryWrappers.eq("uid",acc.getId());
            Agent agg=agentService.getOne(queryWrappers);
            agg.setState(state);
            agentService.updateById(agg);
            Procedures pc= new Procedures();
            //部门分馆审核通过，移交给信息中心主任，如果信息中心主任开启待办移交，移交给副主任。
            if(state==0){

                //信息中心分馆
                QueryWrapper queryWrappere  = new QueryWrapper();
                queryWrappere.eq("departmentId",2);
                Branchlibrary branchlibrary=branchlibraryService.getOne(queryWrappere);
                Account a=accountService.getById(branchlibrary.getUid());
                QueryWrapper queryWrapperc  = new QueryWrapper();
                //开启待办
                if(a!=null&&a.getAgencyState()==1){
                    queryWrapperc.eq("image_dataId",id);
                    borrowProcess.setInformationCenter(a.getAgencyUid());
                    borrowProcess.setInformationCenterState(2);
                    borrowProcess.setCenterconsultId(a.getId());
                    borrowProcess.setDepartmentDirectorTime(SystemDateUtils.getDaDate());
                    borrowProcessService.update(borrowProcess,queryWrapperc);


                    //添加到信息中心分管领导办事项
                    Agent age = new Agent();
                    age.setUid(a.getAgencyUid());
                    age.setCreatetimes(SystemDateUtils.getStrDate());
                    age.setTitles("档案借阅申请单");
                    age.setAgentType(9);
                    age.setImageDataId(id);
                    age.setState(2);
                    age.setSubmitid(acc.getId());
                    agentService.save(age);
                    zid=a.getAgencyUid();
                }else{
                    queryWrapperc.eq("image_dataId",id);
                    borrowProcess.setInformationCenter(a.getId());
                    borrowProcess.setInformationCenterState(2);
                    borrowProcess.setDepartmentDirectorTime(SystemDateUtils.getDaDate());
                    borrowProcessService.update(borrowProcess,queryWrapperc);

                    //添加到信息中心分管领导待办事项
                    Agent age = new Agent();
                    age.setUid(a.getId());
                    age.setCreatetimes(SystemDateUtils.getStrDate());
                    age.setTitles("档案借阅申请单");
                    age.setAgentType(9);
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
     * @param
     * @param
     * @param
     */


    @ApiOperation(value = "信息中心分管领导审核")
    @PostMapping("/centers")
    public void centers( int id,int state,HttpServletRequest req,int grantId,String centerIdea){
        Procedures pc= new Procedures();
        try {
            QueryWrapper queryWrapp  = new QueryWrapper();
            queryWrapp.eq("image_dataId",id);
            Account ac=accountService.findAccount(req);
            BorrowProcess borrowProcess = new  BorrowProcess();
            borrowProcess.setInformationCenterTime(SystemDateUtils.getDaDate());
            borrowProcess.setCenterRemarks(centerIdea);
            borrowProcess.setInformationCenterState(state);
            borrowProcessService.update(borrowProcess,queryWrapp);

            //修改信息中心分管领导待办状态
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

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return borrowFormService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody BorrowForm borrowForm){
        System.out.println(">>>>>>"+ borrowForm);
        return borrowFormService.updateData(borrowForm);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<BorrowForm> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return borrowFormService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public BorrowForm findById(@PathVariable Long id){
        return borrowFormService.findById(id);
    }

}

