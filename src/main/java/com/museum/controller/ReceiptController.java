

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
 * 办公室-收文 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */


@Api(tags = {"办公室-收文"})
@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IReceiptService receiptService;

    @Resource
    private IAccountService accountService;


    @Resource
    private IProceduresService proceduresService;

    @Resource
    private IAgentService agentService;

    @Resource
    private IDepartmentService departmentService;

    @Resource
    private IReceiptProcessService receiptProcessService;


    @ApiOperation(value = "新增办公室-收文")
    @PostMapping("/add")
    public Result add(@RequestBody Receipt receipt, HttpServletRequest req){
        String str= SystemDateUtils.getStrDate();
        Account ac=accountService.findAccount(req);
        receipt.setCreatimes(str);
        receipt.setUid(ac.getId());
        receiptService.add(receipt);

        //获取刚上传的资料
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("createTime",str);
        queryWrappet.eq("uid",ac.getId());
        Receipt imd=receiptService.getOne(queryWrappet);
        int id=imd.getId();

        try {
            //获取馆长
            QueryWrapper queryWrappere  = new QueryWrapper();
            queryWrappere.eq("department_id",1);
            queryWrappere.eq("position_id",2);
            Account acc=accountService.getOne(queryWrappere);
            QueryWrapper queryWrapperc  = new QueryWrapper();
            ReceiptProcess receiptProcess = new ReceiptProcess();
            QueryWrapper queryW  = new QueryWrapper();
            queryW.eq("image_dataId",id);

            //判断是否开启待办转交,1为转交
            if(acc.getAgencyState()==1){
                //给代办人添加到业务流程
                receiptProcess.setUid(ac.getId());
                receiptProcess.setDepartmentDirectorState(2);
                receiptProcess.setInformationCenter(acc.getAgencyUid());
                receiptProcess.setImageDataid(id);
                receiptProcess.setDirectorconsultId(acc.getId());
                receiptProcess.setCreateTime(SystemDateUtils.getStrDate());
                receiptProcess.setTitle("收文批示");
                receiptProcessService.add(receiptProcess);
                //添加到管长待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getAgencyUid());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("收文批示");
                ag.setAgentType(12);
                ag.setImageDataId(id);
                ag.setPosition("3");
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);

            }else {
                //添加到管长的待办流程
                receiptProcess.setUid(ac.getId());
                receiptProcess.setDepartmentDirectorState(2);
                receiptProcess.setInformationCenter(acc.getId());
                receiptProcess.setImageDataid(id);
                receiptProcess.setCreateTime(SystemDateUtils.getStrDate());
                receiptProcess.setTitle("收文批示");
                receiptProcessService.add(receiptProcess);

                //添加到管长待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getId());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("收文批示");
                ag.setAgentType(12);
                ag.setPosition("3");
                ag.setImageDataId(id);
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);
            }


            //添加到我的流程
            Procedures pc= new Procedures();
            pc.setApplyTime(SystemDateUtils.getStrDate());
            pc.setApplyType("收文批示");
            pc.setApplyTypeid(9);
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


    @ApiOperation(value = "管长批示")
    @PostMapping("/guanadd")
    public Result guanadd(@RequestBody TsetBase tsetBase, HttpServletRequest req){
        String str= SystemDateUtils.getStrDate();
        Account ac=accountService.findAccount(req);

        //待办主任事项完成
        QueryWrapper queryWrappers  = new QueryWrapper();
        queryWrappers.eq("image_data_id",tsetBase.getId());
        queryWrappers.eq("uid",ac.getId());
        Agent agg=agentService.getOne(queryWrappers);
        agg.setState(tsetBase.getState());
        agg.setChulitime(SystemDateUtils.getStrDate());
        agentService.updateById(agg);


        try {
            //获取分馆长
            QueryWrapper queryWrappere  = new QueryWrapper();
            queryWrappere.eq("department_id",1);
            queryWrappere.eq("position_id",2);
            Account acc=accountService.getOne(queryWrappere);
            QueryWrapper queryWrapperc  = new QueryWrapper();
            ReceiptProcess receiptProcess = new ReceiptProcess();
            QueryWrapper queryW  = new QueryWrapper();
            queryW.eq("image_dataId",tsetBase.getId());

            //判断是否开启待办转交,1为转交
            if(acc.getAgencyState()==1){
                //给代办人添加到业务流程
                receiptProcess.setInformationCenterState(acc.getAgencyState());
                receiptProcess.setInformationCenter(acc.getAgencyUid());
                receiptProcess.setInformationCenterTime(SystemDateUtils.getStrDate());
                receiptProcess.setImageDataid(tsetBase.getId().intValue());
                receiptProcess.setCenterconsultId(acc.getId());
                receiptProcess.setCreateTime(SystemDateUtils.getStrDate());
                receiptProcess.setTitle("收文批示");
                receiptProcessService.update(receiptProcess,queryW);
                //添加到分管长待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getAgencyUid());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("收文批示");
                ag.setAgentType(12);
                ag.setPosition("4");
                ag.setImageDataId(tsetBase.getId().intValue());
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);

            }else {
                //添加到分管长的待办流程
                receiptProcess.setInformationCenterState(acc.getId());
                receiptProcess.setInformationCenter(acc.getAgencyUid());
                receiptProcess.setInformationCenterTime(SystemDateUtils.getStrDate());
                receiptProcess.setImageDataid(tsetBase.getId().intValue());
                receiptProcess.setCenterconsultId(acc.getId());
                receiptProcess.setCreateTime(SystemDateUtils.getStrDate());
                receiptProcess.setTitle("收文批示");
                receiptProcessService.update(receiptProcess,queryW);

                //添加到分管长待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getId());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("收文批示");
                ag.setAgentType(12);
                ag.setImageDataId(tsetBase.getId().intValue());
                ag.setState(2);
                ag.setPosition("4");
                ag.setSubmitid(ac.getId());
                agentService.save(ag);
            }


                //添加到我的流程
                Procedures pc= new Procedures();
                pc.setApplyTime(SystemDateUtils.getStrDate());
                pc.setApplyType("收文批示");
                pc.setApplyTypeid(9);
                pc.setState(2);
                pc.setPname(ac.getName());
                pc.setProcessId(tsetBase.getId().intValue());
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

    @ApiOperation(value = "分管长批示")
    @PostMapping("/fenadd")
    public Result fenadd(@RequestBody TsetBase tsetBase, HttpServletRequest req){
        String str= SystemDateUtils.getStrDate();
        Account ac=accountService.findAccount(req);

            //待办主任事项完成
            QueryWrapper queryWrappers  = new QueryWrapper();
            queryWrappers.eq("image_data_id",tsetBase.getId());
            queryWrappers.eq("uid",ac.getId());
            Agent agg=agentService.getOne(queryWrappers);
            agg.setChulitime(SystemDateUtils.getStrDate());
            agg.setState(tsetBase.getState());
            agentService.updateById(agg);

        try {
            //获取分馆长
            QueryWrapper queryWrappere  = new QueryWrapper();
            queryWrappere.eq("department_id",1);
            queryWrappere.eq("position_id",3);
            Account acc=accountService.getOne(queryWrappere);
            QueryWrapper queryWrapperc  = new QueryWrapper();
            ReceiptProcess receiptProcess = new ReceiptProcess();
            QueryWrapper queryW  = new QueryWrapper();
            queryW.eq("image_dataId",tsetBase.getId());

            //判断是否开启待办转交,1为转交
            if(acc.getAgencyState()==1){
                //给代办人添加到业务流程
                receiptProcess.setCuratorId(acc.getAgencyUid());
                receiptProcess.setDepartmentCuratorState(acc.getAgencyState());
                receiptProcess.setInformationCenterTime(SystemDateUtils.getStrDate());
                receiptProcess.setImageDataid(tsetBase.getId().intValue());
                receiptProcess.setCenterconsultId(acc.getId());
                receiptProcess.setCreateTime(SystemDateUtils.getStrDate());
                receiptProcess.setTitle("收文批示");
                receiptProcessService.update(receiptProcess,queryW);
                //添加到分管长待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getAgencyUid());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("收文批示");
                ag.setAgentType(12);
                ag.setPosition("4");
                ag.setImageDataId(tsetBase.getId().intValue());
                ag.setState(2);
                ag.setSubmitid(ac.getId());
                agentService.save(ag);

            }else {
                //添加到分管长的待办流程
                receiptProcess.setInformationCenterState(acc.getId());
                receiptProcess.setInformationCenter(acc.getAgencyUid());
                receiptProcess.setInformationCenterTime(SystemDateUtils.getStrDate());
                receiptProcess.setImageDataid(tsetBase.getId().intValue());
                receiptProcess.setCenterconsultId(acc.getId());
                receiptProcess.setCreateTime(SystemDateUtils.getStrDate());
                receiptProcess.setTitle("收文批示");
                receiptProcessService.update(receiptProcess,queryW);

                //添加到分管长待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getId());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("收文批示");
                ag.setAgentType(12);
                ag.setImageDataId(tsetBase.getId().intValue());
                ag.setState(2);
                ag.setPosition("4");
                ag.setSubmitid(ac.getId());
                agentService.save(ag);
            }


            //添加到我的流程
            Procedures pc= new Procedures();
            pc.setApplyTime(SystemDateUtils.getStrDate());
            pc.setApplyType("收文批示");
            pc.setApplyTypeid(9);
            pc.setState(2);
            pc.setPname(ac.getName());
            pc.setProcessId(tsetBase.getId().intValue());
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

    @ApiOperation(value = "部门主任")
    @PostMapping("/buadd")
    public Result buadd(@RequestBody TsetBase tsetBase, HttpServletRequest req){
        String str= SystemDateUtils.getStrDate();
        Account acc=accountService.findAccount(req);

        //待办主任事项完成
        QueryWrapper queryWrappers  = new QueryWrapper();
        queryWrappers.eq("image_data_id",tsetBase.getId());
        queryWrappers.eq("uid",acc.getId());
        Agent agg=agentService.getOne(queryWrappers);
        agg.setState(tsetBase.getState());
        agentService.updateById(agg);
            //添加到我的流程
            Procedures pc= new Procedures();
            pc.setApplyTime(SystemDateUtils.getStrDate());
            pc.setApplyType("收文批示");
            pc.setApplyTypeid(9);
            pc.setState(2);
            pc.setPname(acc.getName());
            pc.setProcessId(tsetBase.getId().intValue());
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



    }

    @ApiOperation(value = "删除办公室-收文")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return receiptService.delete(id);
    }

    @ApiOperation(value = "更新办公室-收文")
    @PutMapping()
    public int update(@RequestBody Receipt receipt){
        return receiptService.updateData(receipt);
    }

    @ApiOperation(value = "查询办公室-收文分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Receipt> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return receiptService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询办公室-收文")
    @GetMapping("{id}")
    public Receipt findById(@PathVariable Long id){
        return receiptService.findById(id);
    }

}


