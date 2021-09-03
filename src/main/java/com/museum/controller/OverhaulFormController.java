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

/**
 * <p>
 * 水电维修维护表单 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
@Api(tags = {"水电维修维护表单"})
@RestController
@RequestMapping("/overhaul-form")
public class OverhaulFormController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IOverhaulFormService overhaulFormService;
    @Resource
    private IAccountService accountService;


    @Resource
    private IProceduresService proceduresService;

    @Resource
    private IAgentService agentService;

    @Resource
    private IDepartmentService departmentService;

    @Resource
    private IOverhaulProcessService overhaulProcessService;



    @ApiOperation(value = "新增水电维修维护表单")
    @PostMapping()
    public Result add(@RequestBody OverhaulForm overhaulForm, HttpServletRequest req){
        Account ac=accountService.findAccount(req);
        String str= SystemDateUtils.getStrDate();
        overhaulForm.setCreatetime(str);
        overhaulForm.setUid(ac.getId());
        overhaulFormService.add(overhaulForm);


        //获取刚上传的资料
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("createTime",str);
        queryWrappet.eq("uid",ac.getId());
        OverhaulForm imd=overhaulFormService.getOne(queryWrappet);
        int id=imd.getId();

        try {
            //获取部门主任
            QueryWrapper queryWrapper  = new QueryWrapper();
            queryWrapper.eq("department_id",ac.getDepartmentId());
            queryWrapper.eq("position_id",3);
            Account acc=accountService.getOne(queryWrapper);
            OverhaulProcess overhaulProcess = new  OverhaulProcess();
            QueryWrapper queryW  = new QueryWrapper();
            queryW.eq("image_dataId",id);

            //判断是否开启待办转交,1为转交
            if(acc.getAgencyState()==1){
                //给代办人添加到业务流程
                overhaulProcess.setUid(ac.getId());
                overhaulProcess.setDepartmentDirectorState(2);
                overhaulProcess.setDepartmentDirectorId(acc.getAgencyUid());
                overhaulProcess.setImageDataid(id);
                overhaulProcess.setDirectorconsultId(acc.getId());
                overhaulProcess.setCreateTime(SystemDateUtils.getStrDate());
                overhaulProcess.setTitle("水电维护维修申请单");
                overhaulProcessService.add(overhaulProcess);
                //添加到待办部门主任待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getAgencyUid());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("水电维护维修申请单");
                ag.setAgentType(7);
                ag.setImageDataId(id);
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);

            }else {
                //添加到主任的待办流程
                overhaulProcess.setUid(ac.getId());
                overhaulProcess.setDepartmentDirectorState(2);
                overhaulProcess.setDepartmentDirectorId(acc.getId());
                overhaulProcess.setImageDataid(id);
                overhaulProcess.setCreateTime(SystemDateUtils.getStrDate());
                overhaulProcess.setTitle("水电维护维修申请单");
                overhaulProcessService.add(overhaulProcess);

                //添加到部门主任待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getId());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("水电维护维修申请单");
                ag.setAgentType(7);
                ag.setImageDataId(id);
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);
            }


            //添加到我的流程
            Procedures pc= new Procedures();
            pc.setApplyTime(SystemDateUtils.getStrDate());
            pc.setApplyType("水电维护维修申请单");
            pc.setApplyTypeid(5);
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
    public Result examination(int id,int state,HttpServletRequest req,OverhaulForm overhaulForm,String director_idea){
        //主任申请资料编辑审核
        overhaulFormService.updateById(overhaulForm);
        int zid;
        try {
            //获取本部门主任id
            Account acc=accountService.findAccount(req);
            //通过id，修改审核状态,和意见
            OverhaulProcess overhaulProcess = new  OverhaulProcess();
            overhaulProcess.setDepartmentDirectorState(state);
            overhaulProcess.setDirectorIdea(director_idea);
            QueryWrapper queryWra  = new QueryWrapper();
            queryWra.eq("image_dataId",id);
            overhaulProcessService.update(overhaulProcess,queryWra);

            //待办主任事项完成
            QueryWrapper queryWrappers  = new QueryWrapper();
            queryWrappers.eq("image_data_id",id);
            queryWrappers.eq("uid",acc.getId());
            Agent agg=agentService.getOne(queryWrappers);
            agg.setState(state);
            agentService.updateById(agg);
            Procedures pc= new Procedures();
            //部门主任审核通过，移交给安保部门主任，如果安保部门主任开启待办移交，移交给副主任。
            if(state==0){
                //安保部门主任
                QueryWrapper queryWrappere  = new QueryWrapper();
                queryWrappere.eq("department_id",3);
                queryWrappere.eq("position_id",3);
                Account a=accountService.getOne(queryWrappere);
                QueryWrapper queryWrapperc  = new QueryWrapper();
                //开启待办
                if(a!=null&&a.getAgencyState()==1){
                    queryWrapperc.eq("image_dataId",id);
                    overhaulProcess.setInformationCenter(a.getAgencyUid());
                    overhaulProcess.setInformationCenterState(2);
                    overhaulProcess.setCenterconsultId(a.getId());
                    overhaulProcess.setDepartmentDirectorTime(SystemDateUtils.getDaDate());
                    overhaulProcessService.update(overhaulProcess,queryWrapperc);


                    //添加到安保部门主任待办事项
                    Agent age = new Agent();
                    age.setUid(a.getAgencyUid());
                    age.setCreatetimes(SystemDateUtils.getStrDate());
                    age.setTitles("水电维护维修申请单");
                    age.setAgentType(7);
                    age.setImageDataId(id);
                    age.setState(2);
                    age.setSubmitid(acc.getId());
                    agentService.save(age);
                    zid=a.getAgencyUid();
                }else{
                    queryWrapperc.eq("image_dataId",id);
                    overhaulProcess.setInformationCenter(a.getId());
                    overhaulProcess.setInformationCenterState(2);
                    overhaulProcess.setDepartmentDirectorTime(SystemDateUtils.getDaDate());
                    overhaulProcessService.update(overhaulProcess,queryWrapperc);

                    //添加到安保主任的待办事项
                    Agent age = new Agent();
                    age.setUid(a.getId());
                    age.setCreatetimes(SystemDateUtils.getStrDate());
                    age.setTitles("水电维护维修申请单");
                    age.setAgentType(7);
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
    @ApiOperation(value = "安全保卫部主任审核")
    @PostMapping("/center")
    public void center( int id,int state,HttpServletRequest req,int grantId,String centerIdea){
        Procedures pc= new Procedures();
        try {
            QueryWrapper queryWrapp  = new QueryWrapper();
            queryWrapp.eq("image_dataId",id);
            Account ac=accountService.findAccount(req);
            OverhaulProcess overhaulProcess = new  OverhaulProcess();
            overhaulProcess.setInformationCenterTime(SystemDateUtils.getDaDate());
            overhaulProcess.setCenterIdea(centerIdea);
            overhaulProcess.setInformationCenterState(state);
            overhaulProcess.setGrantId(grantId);
            overhaulProcessService.update(overhaulProcess,queryWrapp);
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
            pc.setState(state);
            Account acco=accountService.findById(Long.valueOf(grantId));
            Department de=departmentService.findById(Long.valueOf(acco.getDepartmentId()));
            pc.setProcessName(de.getDepartmentName()+"["+acco.getName()+"]");
            proceduresService.update(pc,queryWrap);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "删除水电维修维护表单")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return overhaulFormService.delete(id);
    }

    @ApiOperation(value = "更新水电维修维护表单")
    @PutMapping()
    public int update(@RequestBody OverhaulForm overhaulForm){
        return overhaulFormService.updateData(overhaulForm);
    }

    @ApiOperation(value = "查询水电维修维护表单分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<OverhaulForm> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return overhaulFormService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询水电维修维护表单")
    @GetMapping("{id}")
    public OverhaulForm findById(@PathVariable Long id){
        return overhaulFormService.findById(id);
    }

}
