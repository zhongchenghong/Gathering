package com.museum.controller.weixin;

import com.museum.common.HttpRequest;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 小程序访问量
 */

@Api(tags = {"微信小程序访问量"})
@RestController
@RequestMapping("/summary")
public class DailySummaryController {

    //获取微信小程序access_token
    public static  String access_token(){
        HttpRequest rq= new HttpRequest();
        String sr=HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/token", "grant_type=client_credential&appid=wx9305afd2f3216e48&secret=b27928e95f7fdee34c13e99a1d0cdcf0");
        JSONObject jsonObj = new JSONObject(sr);
        Object age =jsonObj.get("access_token");
        return age.toString();
    }


    //月访问量
    @ApiOperation(value = "月访问量")
    @PostMapping(value = "/getMonthlyVisitTrend")
    public Result getMonthlyVisitTrend(String begin_date,String end_date){
        String str =access_token();
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("begin_date", begin_date);
        jsonParam.put("end_date", end_date);
        String param = jsonParam.toString();
        HttpRequest rq= new HttpRequest();
        String sr=HttpRequest.sendPost2("https://api.weixin.qq.com/datacube/getweanalysisappidmonthlyvisittrend?access_token="+str, param);
        return ResultUtil.success(sr);

    }
    //周访问量
    @ApiOperation(value = "周访问量")
    @PostMapping(value = "/getWeeklyVisitTrend")
    public Result getWeeklyVisitTrend(String begin_date,String end_date){
        String str =access_token();
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("begin_date", begin_date);
        jsonParam.put("end_date", end_date);
        String param = jsonParam.toString();
        String sr=HttpRequest.sendPost2("https://api.weixin.qq.com/datacube/getweanalysisappidweeklyvisittrend?access_token="+str, param);
        return ResultUtil.success(sr);

    }


}

