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
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-20
 */
@Api(tags = {"影像资料采集"})
@RestController
@RequestMapping("/datacollection")
public class DataCollectionController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IDataCollectionService dataCollectionService;
    @Resource
    private IAccountService accountService;

    @Resource
    private IAgentService agentService;

    @Resource
    private IDataCollectionProcessService dataCollectionProcessService;

    @Resource
    private IDepartmentService departmentService;

    @Resource
    private IProceduresService proceduresService;


    @ApiOperation(value = "新增影像资料采集,并提交")
    @PostMapping("/add")
    public Result add(@RequestBody DataCollection dataCollection, HttpServletRequest req){
        try{
            Account at=accountService.findAccount(req);
            dataCollection.setApplytime(SystemDateUtils.getStrDate());
            dataCollection.setUid(Integer.valueOf(at.getDepartmentId()));
            dataCollectionService.add(dataCollection);
            QueryWrapper queryWrappet  = new QueryWrapper();
            queryWrappet.eq("applytime",SystemDateUtils.getStrDate());
            queryWrappet.eq("uid",at.getId());
            DataCollection imd=dataCollectionService.getOne(queryWrappet);
            //获取当前部门主任
            QueryWrapper queryWrapper  = new QueryWrapper();
            queryWrapper.eq("department_id",at.getDepartmentId());
            queryWrapper.eq("position_id",3);
            Account acc=accountService.getOne(queryWrapper);
            int zid;
            //如果部门主任转交给代办人
            DataCollectionProcess dp = new DataCollectionProcess();
            if(acc.getAgencyState()==1){
                dp.setDirectorconsultId(acc.getId());
                dp.setDepartmentDirectorId(Integer.valueOf(acc.getAgencyUid()));
                zid=Integer.valueOf(acc.getAgencyUid());
            }else{
                dp.setDepartmentDirectorId(Integer.valueOf(acc.getId()));
                zid=Integer.valueOf(acc.getId());
            }
                dp.setCreateTime(SystemDateUtils.getStrDate());
                dp.setDepartmentDirectorState(2);
                dp.setImageDataid(imd.getId());
                dp.setUid(at.getId());
                dataCollectionProcessService.save(dp);
            //添加到部门主任待办事项
                Agent ag = new Agent();
                    ag.setUid(zid);
                    ag.setCreatetimes(SystemDateUtils.getStrDate());
                    ag.setTitles("影像资料采集制作申请");
                    ag.setAgentType(3);
                    ag.setImageDataId(imd.getId());
                    ag.setState(3);
                    ag.setSubmitid(at.getId());
                    agentService.save(ag);
            //添加到我的流程
                Procedures pc= new Procedures();
                pc.setApplyTime(SystemDateUtils.getStrDate());
                pc.setApplyType("影像资料采集制作申请");
                pc.setApplyTypeid(1);
                pc.setState(2);
                pc.setPname(at.getName());
                pc.setUid(at.getId());
                pc.setProcessId(imd.getId());
                //部门主任是否开启待办
                if(acc.getAgencyState()==1){
                    pc.setRoles(acc.getAgencyUid());
                    Account aa= accountService.findById(Long.valueOf(acc.getAgencyUid()));
                    Department de=departmentService.findById(Long.valueOf(acc.getDepartmentId()));
                    pc.setProcessName(de.getDepartmentName()+"["+aa.getName()+"]");
                    pc.setState(0);
                }else{
                    pc.setRoles(acc.getId());
                    Department de=departmentService.findById(Long.valueOf(acc.getDepartmentId()));
                    pc.setState(0);
                    pc.setProcessName(de.getDepartmentName()+"["+acc.getName()+"]");
                }
                proceduresService.save(pc);
         }catch (Exception e){
            e.printStackTrace();
            return   ResultUtil.error(401,"申请提交失败");
        }
        return   ResultUtil.success();
    }

    @ApiOperation(value = "部门主任审核")
    @PostMapping("/adds")
    public Result adds(Long id,int state, HttpServletRequest req,String Remarks,DataCollection dataCollection){

        dataCollectionService.updateById(dataCollection);

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
            DataCollectionProcess dp = new DataCollectionProcess();
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
                dataCollectionProcessService.update(dp,queryWrapperc);
                //添加到信息主任待办事项
                age.setUid(a.getAgencyUid());
                age.setCreatetimes(SystemDateUtils.getStrDate());
                age.setTitles("影像资料采集制作申请");
                age.setAgentType(3);
                age.setImageDataId(id.intValue());
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
                dataCollectionProcessService.update(dp,queryWrapperc);
                //添加到信息主任待办事项
                age.setUid(a.getId());
                age.setCreatetimes(SystemDateUtils.getStrDate());
                age.setTitles("影像资料采集制作申请");
                age.setAgentType(3);
                age.setImageDataId(id.intValue());
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
                dataCollectionProcessService.update(dp,queryWrapperc);
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
        int information_center_state = 2;
        Procedures pc= new Procedures();
        try {
            QueryWrapper queryWrapp  = new QueryWrapper();
            queryWrapp.eq("image_dataId",id);

            Account ac=accountService.findAccount(req);
            DataCollectionProcess dataCollectionProcess = new  DataCollectionProcess();
            dataCollectionProcess.setInformationCenterTime(SystemDateUtils.getDaDate());
            if(state==1){
                information_center_state=0;
            }else if(state==0){
                information_center_state=1;
            }
            dataCollectionProcess.setInformationCenterState(information_center_state);
            dataCollectionProcess.setGrantId(grantId);
            dataCollectionProcessService.update(dataCollectionProcess,queryWrapp);
            //修改主任待办状态
            QueryWrapper queryWrapps  = new QueryWrapper();
            queryWrapps.eq("image_data_id",id);
            queryWrapps.eq("uid",ac.getId());
            Agent age = new Agent();
            age.setState(information_center_state);
            agentService.update(age,queryWrapps);

            if(information_center_state==1){
                //推给资料发放的人
                Agent ages = new Agent();
                ages.setUid(grantId);
                ages.setCreatetimes(SystemDateUtils.getStrDate());
                ages.setTitles("影像资料入库,同步发放到申请部门");
                ages.setAgentType(2);
                ages.setImageDataId(id);
                ages.setState(information_center_state);
                ages.setSubmitid(ac.getId());
                agentService.save(age);

            }

            //通过,修改我的流程
            QueryWrapper queryWrap  = new QueryWrapper();
            queryWrap.eq("process_id",id);
            pc.setState(0);
            Account acco=accountService.findById(Long.valueOf(grantId));
            Department de=departmentService.findById(Long.valueOf(acco.getDepartmentId()));
            pc.setProcessName(de.getDepartmentName()+"["+acco.getName()+"]");
            proceduresService.update(pc,queryWrap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return   ResultUtil.success();
    }




    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return dataCollectionService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody DataCollection dataCollection){
        return dataCollectionService.updateData(dataCollection);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<DataCollection> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return dataCollectionService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public DataCollection findById(@PathVariable Long id){
        return dataCollectionService.findById(id);
    }

}
