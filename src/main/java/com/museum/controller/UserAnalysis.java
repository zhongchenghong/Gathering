package com.museum.controller;

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
 * 公众号访问量
 */
@Api(tags = {"公众号用户访问量"})
@RestController
@RequestMapping("/summarys")
public class UserAnalysis {


    public static String access_token(){
        HttpRequest rq= new HttpRequest();
        String sr=HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/token", "grant_type=client_credential&appid=wx9305afd2f3216e48&secret=b27928e95f7fdee34c13e99a1d0cdcf0");
        JSONObject jsonObj = new JSONObject(sr);
        Object age =jsonObj.get("access_token");
        return age.toString();
    }

    //发送 POST 请求获取用户增减数据
    @ApiOperation(value = "请求获取用户增减数据")
    @PostMapping(value = "/getusersummary")
    public Result getusersummary(String begin_date, String end_date){
        String str =access_token();
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("begin_date", begin_date);
        jsonParam.put("end_date", end_date);
        String param = jsonParam.toString();
        HttpRequest rq= new HttpRequest();
        String sr=HttpRequest.sendPost2("https://api.weixin.qq.com/datacube/getusersummary?access_token="+str, param);
        return ResultUtil.success(sr);
    }
    //发送 POST 获取累计用户数据
    @ApiOperation(value = "获取累计用户数据")
    @PostMapping(value = "/getusercumulate")
    public Result getusercumulate(String begin_date, String end_date){
        String str =access_token();
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("begin_date", begin_date);
        jsonParam.put("end_date", end_date);
        String param = jsonParam.toString();
        HttpRequest rq= new HttpRequest();
        String sr=HttpRequest.sendPost("https://api.weixin.qq.com/datacube/getusercumulate?access_token="+str, param);
        return ResultUtil.success(sr);
    }

    public static void main(String[] args) {
        String str =access_token();
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("begin_date", 20210101);
        jsonParam.put("end_date", 20210701);
        String param = jsonParam.toString();
        HttpRequest rq= new HttpRequest();
        System.out.println(str);
        String sr=HttpRequest.sendPost2("https://api.weixin.qq.com/datacube/getusersummary?access_token="+str, param);
       System.out.println(sr);

    }

}
