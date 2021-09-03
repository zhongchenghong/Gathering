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
 * 档案查阅表单 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
@Api(tags = {"档案查阅表单"})
@RestController
@RequestMapping("/file-access-form")
public class FileAccessFormController {



    @Resource
    private IAccountService accountService;


    @Resource
    private IProceduresService proceduresService;

    @Resource
    private IAgentService agentService;

    @Resource
    private IDepartmentService departmentService;

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IFileAccessFormService fileAccessFormService;

    @Resource
    private IFileAccessProcessService fileAccessProcessService;

    @Resource
    private IArchivesService archivesService;

    /**
     * 新增并提交到部门主任
     * @param fileAccessForm
     * @param req
     * @return
     */
    @ApiOperation(value = "新增档案查阅表单")
    @PostMapping("/add")
    public Result add(@RequestBody FileAccessForm fileAccessForm, HttpServletRequest req){
        //添加表单
        Account ac=accountService.findAccount(req);
        String str = SystemDateUtils.getStrDate();
        fileAccessForm.setCreatetime(SystemDateUtils.getStrDate());
        fileAccessForm.setUid(ac.getId());
        fileAccessFormService.add(fileAccessForm);

        //获取刚上传的资料
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("createTime",str);
        queryWrappet.eq("uid",ac.getId());
        FileAccessForm imd=fileAccessFormService.getOne(queryWrappet);
        int id=imd.getId();

        try {
            //获取部门主任
            QueryWrapper queryWrapper  = new QueryWrapper();
            queryWrapper.eq("department_id",ac.getDepartmentId());
            queryWrapper.eq("position_id",3);
            Account acc=accountService.getOne(queryWrapper);
            FileAccessProcess fileAccessProcess = new  FileAccessProcess();
            QueryWrapper queryW  = new QueryWrapper();
            queryW.eq("image_dataId",id);

            //判断是否开启待办转交,1为转交
            if(acc.getAgencyState()==1){
                //给代办人添加到业务流程
                fileAccessProcess.setUid(ac.getId());
                fileAccessProcess.setDepartmentDirectorState(2);
                fileAccessProcess.setDepartmentDirectorId(acc.getAgencyUid());
                fileAccessProcess.setImageDataid(id);
                fileAccessProcess.setDirectorconsultId(acc.getId());
                fileAccessProcess.setCreateTime(SystemDateUtils.getStrDate());
                fileAccessProcess.setTitle("档案查阅申请");
                fileAccessProcessService.add(fileAccessProcess);

                //添加到待办部门主任待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getAgencyUid());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("档案查阅申请");
                ag.setAgentType(4);
                ag.setImageDataId(id);
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);

            }else {
                //添加到主任的待办流程
                fileAccessProcess.setUid(ac.getId());
                fileAccessProcess.setDepartmentDirectorState(2);
                fileAccessProcess.setDepartmentDirectorId(acc.getId());
                fileAccessProcess.setImageDataid(id);
                fileAccessProcess.setCreateTime(SystemDateUtils.getStrDate());
                fileAccessProcess.setTitle("档案查阅申请");
                fileAccessProcessService.add(fileAccessProcess);

                //添加到部门主任待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getId());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("档案查阅申请");
                ag.setAgentType(4);
                ag.setImageDataId(id);
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);
            }


            //添加到我的流程
            Procedures pc= new Procedures();
            pc.setApplyTime(SystemDateUtils.getStrDate());
            pc.setApplyType("档案查阅申请");
            pc.setApplyTypeid(3);
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


    @ApiOperation(value = "新增档案查阅部门主任审核")
    @PostMapping("/addirector")
    public Result addDirector(@RequestBody FileAccessForm fileAccessForm, HttpServletRequest req,int state,int id,String Remarks){

        fileAccessFormService.updateById(fileAccessForm);
        Account acc=accountService.findAccount(req);
        Procedures pc= new Procedures();
        int directorState;
        //查询信息主任
        QueryWrapper queryWrappere  = new QueryWrapper();
        queryWrappere.eq("department_id",2);
        queryWrappere.eq("position_id",3);
        Account a=accountService.getOne(queryWrappere);
        QueryWrapper queryWrapperc  = new QueryWrapper();
        //信息主任开启待办
        FileAccessProcess dp = new FileAccessProcess();
        Agent age = new Agent();
        //通过后
        if(state==0){
            if(a!=null&&a.getAgencyState()==1){
                dp.setDepartmentDirectorState(state);
                queryWrapperc.eq("image_dataId",id);
                dp.setInformationCenter(a.getAgencyUid());
                dp.setInformationCenterState(2);
                dp.setCenterconsultId(a.getId());
                dp.setDirectorRemarks(Remarks);
                dp.setDepartmentDirectorTime(SystemDateUtils.getDaDate());
                fileAccessProcessService.update(dp,queryWrapperc);
                //添加到信息主任待办事项
                age.setUid(a.getAgencyUid());
                age.setCreatetimes(SystemDateUtils.getStrDate());
                age.setTitles("档案查阅申请");
                age.setAgentType(3);
                age.setImageDataId(id);
                age.setState(2);
                age.setSubmitid(acc.getId());
                agentService.save(age);

                //通过,修改我的流程
                QueryWrapper queryWrapp  = new QueryWrapper();
                queryWrapp.eq("process_id",id);
                pc.setState(0);
                Account acco=accountService.findById(Long.valueOf(a.getAgencyUid()));
                Department de=departmentService.findById(Long.valueOf(acco.getDepartmentId()));
                pc.setProcessName(de.getDepartmentName()+"["+acco.getName()+"]");
                proceduresService.update(pc,queryWrapp);

            }else{
                //信息主任未开启待办
                queryWrapperc.eq("image_dataId",id);
                dp.setInformationCenter(a.getId());
                dp.setInformationCenterState(2);
                dp.setDepartmentDirectorState(state);
                dp.setDirectorRemarks(Remarks);
                dp.setDepartmentDirectorTime(SystemDateUtils.getDaDate());
                fileAccessProcessService.update(dp,queryWrapperc);
                //添加到信息主任待办事项
                age.setUid(a.getId());
                age.setCreatetimes(SystemDateUtils.getStrDate());
                age.setTitles("影像资料采集制作申请");
                age.setAgentType(3);
                age.setImageDataId(id);
                age.setState(2);
                age.setSubmitid(acc.getId());
                agentService.save(age);

                //通过,修改我的流程
                QueryWrapper queryWrapp  = new QueryWrapper();
                queryWrapp.eq("process_id",id);
                pc.setState(0);
                Department de=departmentService.findById(Long.valueOf(a.getDepartmentId()));
                pc.setProcessName(de.getDepartmentName()+"["+a.getName()+"]");
                proceduresService.update(pc,queryWrapp);
            }
            //修改部门主任待办事项
            QueryWrapper queryWrapps  = new QueryWrapper();
            queryWrapps.eq("image_data_id",id);
            queryWrapps.eq("uid",acc.getId());
            Agent ages = new Agent();
            ages.setState(0);
            agentService.update(ages,queryWrapps);


        }else{
            //未通过
            queryWrapperc.eq("image_dataId",id);
            dp.setDepartmentDirectorState(1);
            dp.setDirectorRemarks(Remarks);
            dp.setDepartmentDirectorTime(SystemDateUtils.getDaDate());
            fileAccessProcessService.update(dp,queryWrapperc);
            //未通过 修改部门主任待办事项
            QueryWrapper queryWrapps  = new QueryWrapper();
            queryWrapps.eq("image_data_id",id);
            queryWrapps.eq("uid",acc.getId());
            Agent ages = new Agent();
            ages.setState(0);
            agentService.update(ages,queryWrapps);
            //未通过,修改我的流程
            QueryWrapper queryWrapp  = new QueryWrapper();
            queryWrapp.eq("process_id",id);
            pc.setState(2);
            Department de=departmentService.findById(Long.valueOf(acc.getDepartmentId()));
            pc.setProcessName(de.getDepartmentName()+"["+acc.getName()+"]");
            proceduresService.update(pc,queryWrapp);
        }
        return   ResultUtil.success();
    }

    @ApiOperation(value = "信息中心主任审核")
    @PostMapping("/center")
    public Result addcenter(int id,int state, HttpServletRequest req,String Remarks,int grantId){
        Procedures pc= new Procedures();
        String str= SystemDateUtils.getStrDate();
        try {
            QueryWrapper queryWrapp  = new QueryWrapper();
            queryWrapp.eq("image_dataId",id);

            Account ac=accountService.findAccount(req);
            FileAccessProcess fileAccessProcess = new  FileAccessProcess();
            fileAccessProcess.setInformationCenterTime(str);

            fileAccessProcess.setInformationCenterState(state);
            fileAccessProcess.setGrantId(grantId);
            fileAccessProcessService.update(fileAccessProcess,queryWrapp);
            //修改主任待办状态
            QueryWrapper queryWrapps  = new QueryWrapper();
            queryWrapps.eq("image_data_id",id);
            queryWrapps.eq("uid",ac.getId());
            Agent age = new Agent();
            age.setState(state);
            agentService.update(age,queryWrapps);


            //通过,修改我的流程
            QueryWrapper queryWrap  = new QueryWrapper();
            queryWrap.eq("process_id",id);
            pc.setState(0);
            Account acco=accountService.findById(Long.valueOf(grantId));
            Department de=departmentService.findById(Long.valueOf(acco.getDepartmentId()));
            pc.setProcessName(de.getDepartmentName()+"["+acco.getName()+"]");
            proceduresService.update(pc,queryWrap);
            FileAccessForm ff=fileAccessFormService.findById(Long.valueOf(id));
            if(state==0){
                //通过添加到档案借阅表单
                Archives arc= new Archives();
                arc.setUid(ac.getId());
                arc.setCreateTime(str);
                arc.setArchivesName(ff.getAccessTitle());
                arc.setBorrowingName(ff.getAccessName());
                arc.setTypes(1);
                archivesService.add(arc);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return   ResultUtil.success();
    }

    @ApiOperation(value = "删除档案查阅表单")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return fileAccessFormService.delete(id);
    }

    @ApiOperation(value = "更新档案查阅表单")
    @PutMapping()
    public int update(@RequestBody FileAccessForm fileAccessForm){
        return fileAccessFormService.updateData(fileAccessForm);
    }

    @ApiOperation(value = "查询档案查阅表单分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<FileAccessForm> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return fileAccessFormService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询档案查阅表单")
    @GetMapping("{id}")
    public FileAccessForm findById(@PathVariable Long id){
        return fileAccessFormService.findById(id);
    }

}
