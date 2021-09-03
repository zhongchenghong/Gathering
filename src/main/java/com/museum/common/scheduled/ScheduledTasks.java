package com.museum.common.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.HttpRequest;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.*;
import com.museum.service.*;
import com.museum.util.SystemDateUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import  org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 定时器任务
 */
@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private  static final SimpleDateFormat dataFromat = new SimpleDateFormat("HH:mm:ss");
    @Resource
    private ITestingEquipmentDataService testingEquipmentDataService;

    @Resource
    private IAccountService accountService;

    @Resource
    private IMissionPlanService missionPlanService;

    @Resource
    private IAgentService agentService;

    @Resource
    private ITestingEquipmentService testingEquipmentService;

    @Resource
    private ITestingTypeService testingTypeService;

    @Resource
    private IActivityRegistrationService activityRegistrationService;

    //日程安排未完成进待办事项
   @Scheduled(cron = "0 0 1 * * ?")
    public void reportCurrent(){
       String date=SystemDateUtils.getStrDate();
       QueryWrapper queryWrapper  = new QueryWrapper();
       queryWrapper.eq("planstate",0);
       List<MissionPlan> list=missionPlanService.list(queryWrapper);
       for (int i=0;i<list.size();i++){
           QueryWrapper queryWrapperw  = new QueryWrapper();
           queryWrapperw.eq("mission_plan_id",list.get(i).getId());
           Agent aaa=agentService.getOne(queryWrapperw);
           if(aaa==null){
               Agent ag= new Agent();
               ag.setTitles(list.get(i).getPlanContent());
               ag.setMissionPlanId(list.get(i).getId());
               ag.setCreatetimes(date);
               ag.setUid(list.get(i).getUid());
               agentService.saveOrUpdate(ag);
           }

       }

    }

   //活动报名小程序获取数据
    @Scheduled(fixedRate=1000000)
    public  void getActivityRegistration(){

        String str=HttpRequest.sendPost3("https://service.wuhouci.net.cn/api/admin/thirdParty/queryApplyList","startTime=2018-01-01 00:00:00&endTime=2021-08-05 00:00:00&pageSize=999999&pageNum=1",getactivityRegistration());
        ActivityRegistration ar = new ActivityRegistration();
        JSONObject jsonObj = new JSONObject(str);
        JSONArray agea=jsonObj.getJSONArray("data");
        for (int i=0;i<agea.length();i++){
            String name = agea.getJSONObject(i).getString("name");
            String gender = agea.getJSONObject(i).getString("gender");
            int ages = agea.getJSONObject(i).getInt("age");
            //String grade = agea.getJSONObject(i).getString("grade");
            String registerTime = agea.getJSONObject(i).getString("registerTime");
            String id = agea.getJSONObject(i).getString("id");
            ar.setCreateTime(SystemDateUtils.getStrDate());
            ar.setGender(gender);
            ar.setName(name);
            ar.setGrade(ages+"");
            ar.setRegisterTime(registerTime);
            ar.setIdm(id);
            QueryWrapper queryWrap  = new QueryWrapper();
            queryWrap.eq("idm",id);
            if(activityRegistrationService.list(queryWrap).size()<=0){
                activityRegistrationService.add(ar);
            }


        }


    }



    //获取保护信息管理系统数据
    @Scheduled(fixedRate=10000000)
    public void getTestingEquipment(){
        List<TestingEquipment> te=testingEquipmentService.list();
        TestingEquipmentData testingEquipmentData = new TestingEquipmentData();
        List<TestingType> li=testingTypeService.list();
        for (TestingEquipment tem :te){
            if(tem.getEquipmenttypeId()==1||tem.getEquipmenttypeId()==2){

                String str=HttpRequest.sendGet("http://47.105.215.208:8005/intfa/queryData/"+tem.getEquipmentId(),"");
                JSONObject jsonObj = new JSONObject(str);
                JSONArray age=jsonObj.getJSONArray("entity");
                for (int i=0;i<age.length();i++){
                    String datetime = age.getJSONObject(i).getString("datetime");
                    String eUnit = age.getJSONObject(i).getString("eUnit");
                    String eValue = age.getJSONObject(i).getString("eValue");
                    String eName = age.getJSONObject(i).getString("eName");
                    String eNum = age.getJSONObject(i).getString("eNum");
                    String eKey = age.getJSONObject(i).getString("eKey");
                    for(TestingType tt:li){
                        if(tt.getTypeName().equals(eName)){
                            testingEquipmentData.setTypeid(tt.getId());
                        }
                    }
                    testingEquipmentData.setCreateTime(new Date());
                    testingEquipmentData.setEKey(eKey);
                    testingEquipmentData.setEName(eName);
                    testingEquipmentData.setEquipmentname(jsonObj.get("deviceName").toString());
                    testingEquipmentData.setENum(eNum);
                    testingEquipmentData.setEValue(eValue);
                    testingEquipmentData.setEUnit(eUnit);
                    testingEquipmentData.setDatetime(datetime);
                    testingEquipmentData.setEquipmenttype(tem.getEquipmentname());
                    testingEquipmentDataService.add(testingEquipmentData);

                }
                }

                if(tem.getEquipmenttypeId()==3){

                    String str1=HttpRequest.sendGet("http://47.105.215.208:8005/intfa/queryData/"+tem.getEquipmentId(),"");
                    JSONObject jsonObj1 = new JSONObject(str1);
                    JSONArray age1=jsonObj1.getJSONArray("entity");
                    for (int i=0;i<age1.length();i++){
                        String datetime = age1.getJSONObject(i).getString("datetime");
                        String eUnit = age1.getJSONObject(i).getString("eUnit");
                        String eValue = age1.getJSONObject(i).getString("eValue");
                        String eName = age1.getJSONObject(i).getString("eName");
                        String eNum = age1.getJSONObject(i).getString("eNum");
                        String eKey = age1.getJSONObject(i).getString("eKey");
                        if("%RH".equals(eUnit)){
                            testingEquipmentData.setTypeid(2);
                        }
                        if("℃".equals(eUnit)){
                            testingEquipmentData.setTypeid(1);
                        }
                        testingEquipmentData.setCreateTime(new Date());
                        testingEquipmentData.setEKey(eKey);
                        testingEquipmentData.setEName(eName);
                        testingEquipmentData.setEquipmentname(jsonObj1.get("deviceName").toString());
                        testingEquipmentData.setENum(eNum);
                        testingEquipmentData.setEValue(eValue);
                        testingEquipmentData.setEUnit(eUnit);
                        testingEquipmentData.setDatetime(datetime);
                        testingEquipmentData.setEquipmenttype(tem.getEquipmentname());
                        testingEquipmentDataService.add(testingEquipmentData);
                    }


                    }



            }


        }


    public static String getactivityRegistration(){
        String str= HttpRequest.sendPost("https://service.wuhouci.net.cn/api/admin/thirdParty/getAccessToken","account=shuwon&passWord=a5f767f56a508e143de28224fafba332");
        JSONObject jsonObj = new JSONObject(str);
        JSONObject jsonObj1 = new JSONObject(jsonObj.get("data").toString());
        return jsonObj1.get("Authorization").toString();
        }




    }


