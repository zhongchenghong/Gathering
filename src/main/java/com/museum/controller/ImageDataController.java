package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.domain.TsetBase;
import com.museum.domain.*;
import com.museum.service.*;
import com.museum.util.FileUtil;
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
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-15
 */
@Api(tags = {"影像资料申请"})
@RestController
@RequestMapping("/image-data")
public class ImageDataController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IImageDataService imageDataService;

    @Resource
    private IAccountService accountService;

    @Resource
    private IImageDataProcessService imageDataProcessService;

    @Resource
    private IProceduresService proceduresService;

    @Resource
    private IAgentService agentService;

    @Resource
    private IDepartmentService departmentService;

    @Resource
    private IResourcesService resourcesService;

    @Resource
    private INoticeService noticeService;

    @ApiOperation(value = "添加影像资料并申请影像资料")
    @PostMapping()
    public Result add(@RequestBody ImageData imageData, HttpServletRequest req){
        QueryWrapper queryWrappery  = new QueryWrapper();
        queryWrappery.eq("filename",imageData.getFileName());
        Resources re = resourcesService.getOne(queryWrappery);

        if(re==null){
            return   ResultUtil.error(401,"申请的影像资料不存在");
        }
        QueryWrapper queryWrappetw  = new QueryWrapper();
        //上传影像资料
        String str= SystemDateUtils.getStrDate();
        Account ac=accountService.findAccount(req);
        imageData.setCreateTime(str);
        imageData.setUid(ac.getId());
        //2未申请
        imageData.setState(2);
        imageData.setDepartmentId(Integer.valueOf(ac.getDepartmentId()));
        imageDataService.add(imageData);
        //获取刚上传的资料
        QueryWrapper queryWrappet  = new QueryWrapper();
        queryWrappet.eq("createTime",str);
        queryWrappet.eq("uid",ac.getId());
        ImageData imd=imageDataService.getOne(queryWrappet);
        int id=imd.getId();

        try {
            //获取部门主任
            QueryWrapper queryWrapper  = new QueryWrapper();
            queryWrapper.eq("department_id",ac.getDepartmentId());
            queryWrapper.eq("position_id",3);
            Account acc=accountService.getOne(queryWrapper);
            ImageDataProcess imageDataProcess = new  ImageDataProcess();
            QueryWrapper queryW  = new QueryWrapper();
            queryW.eq("image_dataId",id);

            //判断是否开启待办转交,1为转交
            if(acc.getAgencyState()==1){
                String ss=SystemDateUtils.getStrDate();
                //给代办人添加到业务流程
                //imageDataProcess.setUid(ac.get);
                imageDataProcess.setDepartmentDirectorState(2);
                imageDataProcess.setDepartmentDirectorId(acc.getAgencyUid());
                imageDataProcess.setImage_dataId(id);
                imageDataProcess.setCenterconsultId(acc.getId());
                imageDataProcess.setCreateTime(ss);
                imageDataProcess.setTitle("影像资料申请单");
                imageDataProcessService.add(imageDataProcess);

                QueryWrapper queryWe  = new QueryWrapper();
                queryW.eq("createTime",ss);
                queryW.eq("image_dataId",id);
                ImageDataProcess is= imageDataProcessService.getOne(queryW);
                //添加到待办部门主任待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getAgencyUid());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("影像资料申请单");
                ag.setAgentType(2);
                ag.setImageDataId(id);
                ag.setState(2);
                ag.setPosition("1");
                ag.setSubmitid(ac.getId());
                ag.setSubmitname(ac.getName());
                ag.setFaqitime(SystemDateUtils.getStrDate());
                ag.setImageDataPro(is.getId()+"");
                agentService.save(ag);

             }else {
                //添加到主任的待办流程
                imageDataProcess.setUid(ac.getId());
                imageDataProcess.setDepartmentDirectorState(2);
                imageDataProcess.setDepartmentDirectorId(acc.getId());
                imageDataProcess.setImage_dataId(id);
                imageDataProcess.setCreateTime(SystemDateUtils.getStrDate());
                imageDataProcess.setTitle("影像资料申请单");
                imageDataProcessService.add(imageDataProcess);

                String ss=SystemDateUtils.getStrDate();
                QueryWrapper queryWe  = new QueryWrapper();
                queryW.eq("createTime",ss);
                queryW.eq("image_dataId",id);
                ImageDataProcess is= imageDataProcessService.getOne(queryW);

                //添加到部门主任待办事项
                Agent ag = new Agent();
                ag.setUid(acc.getId());
                ag.setCreatetimes(SystemDateUtils.getStrDate());
                ag.setTitles("影像资料申请单");
                ag.setAgentType(2);
                ag.setImageDataId(id);
                ag.setState(2);
                ag.setPosition("1");
                ag.setSubmitid(ac.getId());
                ag.setSubmitname(ac.getName());
                ag.setImageDataPro(is.getId()+"");
                ag.setFaqitime(SystemDateUtils.getStrDate());
                agentService.save(ag);
            }
            //设置申请时间
            ImageData ida= new ImageData();
            ida.setId(id);
            ida.setApplyTime(SystemDateUtils.getDaDate());
            imageDataService.updateById(ida);



            //添加到我的流程
            Procedures pc= new Procedures();
            pc.setApplyTime(SystemDateUtils.getStrDate());
            pc.setApplyType("影像资料申请单");
            pc.setApplyTypeid(1);
            pc.setState(2);
            pc.setPname(ac.getName());
            pc.setUid(ac.getId());
            pc.setProcessId(id);
            if(acc.getAgencyState()==1){
                pc.setRoles(acc.getAgencyUid());
                Account aa= accountService.findById(Long.valueOf(acc.getAgencyUid()));
                Department de=departmentService.findById(Long.valueOf(acc.getDepartmentId()));
                pc.setProcessName(de.getDepartmentName()+"["+aa.getName()+"]");
            }else{
                pc.setRoles(acc.getId());
                Department de=departmentService.findById(Long.valueOf(acc.getDepartmentId()));
                pc.setProcessName(de.getDepartmentName()+"["+acc.getName()+"]");
            }
            proceduresService.save(pc);
            return   ResultUtil.success();

        }catch (Exception e){
            e.printStackTrace();
            return   ResultUtil.error(401,"申请提交失败");
        }

    }


    @ApiOperation(value = "部门主任审核")
    @PostMapping("/examination")
    public Result examination(@RequestBody TsetBase tset, HttpServletRequest req){
        //主任申请资料编辑审核
        //imageDataService.updateById(imageData);
        int zid;
        try {
            //获取本部门主任id
            Account acc=accountService.findAccount(req);
            //通过id，修改审核状态,和意见
            ImageDataProcess imageDataProcess = new  ImageDataProcess();
            imageDataProcess.setDepartmentDirectorState(tset.getState());
            imageDataProcess.setDirectorIdea(tset.getDirectorIdea());
            QueryWrapper queryWra  = new QueryWrapper();
            queryWra.eq("image_dataId",tset.getId());
            imageDataProcessService.update(imageDataProcess,queryWra);

            //待办主任事项完成
            QueryWrapper queryWrappers  = new QueryWrapper();
            queryWrappers.eq("image_data_id",tset.getId());
            queryWrappers.eq("uid",acc.getId());
            Agent agg=agentService.getOne(queryWrappers);
            agg.setState(tset.getState());
            agg.setChulitime(SystemDateUtils.getStrDate());
            agentService.updateById(agg);
            if(Integer.valueOf(acc.getDepartmentId())!=2){
            Procedures pc= new Procedures();
            //部门主任审核通过，移交给信息中心主任，如果信息中心主任开启待办移交，移交给副主任。
            if(tset.getState()==0){
                //信息中心主任
                QueryWrapper queryWrappere  = new QueryWrapper();
                queryWrappere.eq("department_id",2);
                queryWrappere.eq("position_id",3);
                Account a=accountService.getOne(queryWrappere);
                QueryWrapper queryWrapperc  = new QueryWrapper();
                //开启待办
                if(a!=null&&a.getAgencyState()==1){
                    queryWrapperc.eq("image_dataId",tset.getId());
                    imageDataProcess.setInformationCenter(a.getAgencyUid());
                    imageDataProcess.setInformationCenterState(2);
                    imageDataProcess.setCenterconsultId(a.getId());
                    imageDataProcess.setDepartmentDirectorTime(SystemDateUtils.getStrDate());
                    imageDataProcessService.update(imageDataProcess,queryWrapperc);


                        //添加到信息中心主人待办人的待办事项事项
                        Agent age = new Agent();
                        age.setUid(a.getAgencyUid());
                        age.setCreatetimes(SystemDateUtils.getStrDate());
                        age.setTitles("影像资料申请单");
                        age.setAgentType(2);
                        age.setImageDataId(tset.getId().intValue());
                        age.setState(2);
                        age.setSubmitid(acc.getId());
                        age.setPosition("2");
                        age.setSubmitname(agg.getSubmitname());
                        age.setFaqitime(agg.getFaqitime());
                        agentService.save(age);
                        zid=a.getAgencyUid();


                }else{
                        queryWrapperc.eq("image_dataId",tset.getId());
                        imageDataProcess.setInformationCenter(a.getId());
                        imageDataProcess.setInformationCenterState(2);
                        imageDataProcess.setDepartmentDirectorTime(SystemDateUtils.getStrDate());
                        imageDataProcessService.update(imageDataProcess,queryWrapperc);
                        //添加到信息中心主人的待办事项
                        Agent age = new Agent();
                        age.setUid(a.getId());
                        age.setCreatetimes(SystemDateUtils.getStrDate());
                        age.setTitles("影像资料申请单");
                        age.setAgentType(2);
                        age.setImageDataId(tset.getId().intValue());
                        age.setState(2);
                        age.setSubmitid(acc.getId());
                        age.setSubmitname(agg.getSubmitname());
                        age.setFaqitime(agg.getFaqitime());
                        age.setPosition("2");
                        agentService.save(age);

                        ImageDataProcess idp= imageDataProcessService.getOne(queryWrapperc);
                        QueryWrapper queryWrapps  = new QueryWrapper();
                        queryWrapps.eq("image_data_pro",idp.getId());
                        Agent as=agentService.getOne(queryWrapps);
                        as.setState(0);
                        agentService.update(as,queryWrapps);

                       zid=a.getId();
                       //通过,修改我的流程
                        QueryWrapper queryWrapp  = new QueryWrapper();
                        queryWrapp.eq("process_id",tset.getId());
                        pc.setState(2);
                        Account acco=accountService.findById(Long.valueOf(zid));
                        Department de=departmentService.findById(Long.valueOf(acco.getDepartmentId()));
                        pc.setProcessName(de.getDepartmentName()+"["+acco.getName()+"]");
                        proceduresService.update(pc,queryWrapp);
                     }
                     }else{
                    QueryWrapper queryWrapperc  = new QueryWrapper();
                    queryWrapperc.eq("image_dataId",tset.getId());
                    ImageDataProcess idp= imageDataProcessService.getOne(queryWrapperc);
                    QueryWrapper queryWrappw  = new QueryWrapper();
                    queryWrappw.eq("id",idp.getId());
                    idp.setDepartmentDirectorState(0);
                    idp.setDepartmentDirectorTime(SystemDateUtils.getStrDate());
                    imageDataProcessService.update(idp,queryWrappw);

                    QueryWrapper queryWrapps  = new QueryWrapper();
                    queryWrapps.eq("image_data_pro",idp.getId());
                    Agent as=agentService.getOne(queryWrapps);
                    as.setState(0);
                    agentService.update(as,queryWrapps);
                    //未通过,修改我的流程
                    QueryWrapper queryWrapp  = new QueryWrapper();
                    queryWrapp.eq("process_id",tset.getId());
                    pc.setState(1);
                    proceduresService.update(pc,queryWrapp);
            }}
            System.out.println(">>>>>>>>>>>>"+ResultUtil.success(2));

            return   ResultUtil.success(2);
        }catch (Exception e){
            e.printStackTrace();
            return   ResultUtil.error(401,"出现未知错误");
        }

    }



    /**
     *
     */
    @ApiOperation(value = "信息中心审核")
    @PostMapping("/center")
    public Result center(@RequestBody ImageCenterIdea tmageCenterIdea, HttpServletRequest req){
        System.out.println("信息中心审核传入的数据》》》》》》》》》》》》" + tmageCenterIdea);
        Procedures pc= new Procedures();
        try {
        QueryWrapper queryWrapp  = new QueryWrapper();
        queryWrapp.eq("image_dataId",tmageCenterIdea.getId());
        Account ac=accountService.findAccount(req);
        ImageDataProcess imageDataProcess = new  ImageDataProcess();
        imageDataProcess.setInformationCenterTime(SystemDateUtils.getStrDate());
        imageDataProcess.setCenterIdea(tmageCenterIdea.getCenterIdea());
        imageDataProcess.setInformationCenterState(tmageCenterIdea.getState());
        imageDataProcess.setGrantId(tmageCenterIdea.getGrantId());
        imageDataProcessService.update(imageDataProcess,queryWrapp);
        //修改主任待办状态
        QueryWrapper queryWrapps  = new QueryWrapper();
        queryWrapps.eq("image_data_id",
                tmageCenterIdea.getId());
        queryWrapps.eq("uid",ac.getId());
        Agent age = new Agent();
        age.setState(0);
        age.setChulitime(SystemDateUtils.getStrDate());
        agentService.update(age,queryWrapps);
        QueryWrapper queryW  = new QueryWrapper();
        queryW.eq("id",tmageCenterIdea.getId());
        ImageData im=  imageDataService.getOne(queryW);


        if(tmageCenterIdea.getState()==0){
            Notice nt =new Notice();
            nt.setTitle("影像资料发放");
            nt.setContent(tmageCenterIdea.getContent());
            nt.setUid(im.getUid());
            nt.setCreatTime(SystemDateUtils.getStrDate());
            noticeService.add(nt);
        }
            //通过,修改我的流程
            QueryWrapper queryWrap  = new QueryWrapper();
            queryWrap.eq("process_id",im.getId());
            pc.setState(tmageCenterIdea.getState());
            proceduresService.update(pc,queryWrap);
        }catch (Exception e){
            e.printStackTrace();
            return  ResultUtil.error(401,"未知错误");
        }
        System.out.println(">>>>>>>>>>>>>>"+ResultUtil.success());
        return  ResultUtil.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return imageDataService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody ImageData imageData){
        String  str=SystemDateUtils.getStrDate();
        imageData.setCreateTime(str);
        return imageDataService.updateData(imageData);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ImageData> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        QueryWrapper queryWrapp  = new QueryWrapper();
        queryWrapp.select().orderByDesc("createTime");
        return imageDataService.page(imageDataService.findListByPage(page, pageCount),queryWrapp);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public ImageData findById(@PathVariable Long id){
        return imageDataService.findById(id);
    }

    @ApiOperation(value = "影像资料下载")
    @GetMapping("/down")
    public void findById(String name, HttpServletResponse res,HttpServletRequest req){

        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("filename",name);
        Resources re = resourcesService.getOne(queryWrapper);
        try {
            FileUtil.download(re.getReaddress(),res,re,req);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
