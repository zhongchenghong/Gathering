package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.ActivityEntryCountByYear;
import com.museum.domain.ScreenResources;
import com.museum.service.IAccountService;
import com.museum.util.HttpContextUtil;
import com.museum.util.SystemDateUtils;
import com.museum.util.WangEditor;
import com.museum.util.page.PageList;
import com.museum.util.page.PageListUtil;
import io.swagger.annotations.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IActivityEntryService;
import com.museum.domain.ActivityEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 活动录入 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-03
 */
@Api(tags = {"工会--工会活动录入"})
@RestController
@RequestMapping("/activity-entry")
public class ActivityEntryController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IActivityEntryService activityEntryService;

    @Resource
    private IAccountService accountService;

    //文件地址
    @Value("${File}")
    private String File;


    @ApiOperation(value = "新增活动")
    @PostMapping()
    public int add(  @RequestParam("starttime")String starttime,
                     @RequestParam("endtime")String endtime,
                     @RequestParam("name")String name,
                     @RequestParam("name")String release,
                     @RequestParam("activityAddress")String activityAddress,
                     @RequestParam("peopleSum")String peopleSum,
                     HttpServletRequest req, MultipartFile file){

        ActivityEntry activityEntry = new ActivityEntry();
        activityEntry.setStarttime(starttime);
        activityEntry.setEndtime(endtime);
        activityEntry.setName(name);
        activityEntry.setActivityAddress(activityAddress);
        activityEntry.setPeopleSum(peopleSum);
        String str=SystemDateUtils.getStrDate();
        Account ac=accountService.findAccount(req);
        activityEntry.setUid(ac.getId());
        activityEntry.setCreatetimes(str);

        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            File fileSave = new File(File, newVidoeName);
            FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
            activityEntry.setFileaddress(fileSave.getCanonicalPath());
            activityEntry.setFilename(file.getOriginalFilename());

        }catch (Exception e){
        e.printStackTrace();

        }
        return activityEntryService.add(activityEntry);
    }

    @ApiOperation(value = "删除活动内容")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return activityEntryService.delete(id);
    }

    @ApiOperation(value = "更新活动")
    @PutMapping()
    public int update(@RequestBody ActivityEntry activityEntry){
        return activityEntryService.updateData(activityEntry);
    }

    @ApiOperation(value = "查询活动分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/getActivityEntry")
    public PageList<ActivityEntry> findListByPage(@RequestParam Integer page,
                                                          @RequestParam Integer pageCount,String title) {
        List<ActivityEntry> acc= new ArrayList();
        QueryWrapper queryWrapper = new QueryWrapper();
        if(title!=null&&!"".equals(title)){
            queryWrapper.like("name", title);
        }
        List<ActivityEntry> ac= activityEntryService.list(queryWrapper);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (ActivityEntry a : ac){
           try {

            Date sd1=df.parse(df.format(new Date()));
            Date sd2=df.parse(a.getEndtime().toString());
            if(sd1.before(sd2)==true){
                a.setState(2);
            }else {
                a.setState(1);
            }
               acc.add(a);
           }catch (ParseException p){{
             }
           }
        }
        return PageListUtil.getPageList(acc.size(),page,acc,pageCount);
    }


    @ApiOperation(value = "工会活动统计")
    @PostMapping("/getActivityEntrycount")
    public List<ActivityEntryCountByYear> findById(){
        return activityEntryService.selectCountByYearIService();
    }

}
