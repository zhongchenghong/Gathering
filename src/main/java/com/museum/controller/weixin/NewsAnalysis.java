package com.museum.controller.weixin;

import com.museum.common.HttpRequest;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import io.swagger.annotations.Api;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class NewsAnalysis {

    public static  String access_token(){
        HttpRequest rq= new HttpRequest();
        String sr=HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/token", "grant_type=client_credential&appid=wx9305afd2f3216e48&secret=b27928e95f7fdee34c13e99a1d0cdcf0");
        JSONObject jsonObj = new JSONObject(sr);
        Object age =jsonObj.get("access_token");
        return age.toString();
    }

    //获取消息发送概况数据
    public Result getupstreammsg(String begin_date, String end_date){
        String str =access_token();
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("begin_date", begin_date);
        jsonParam.put("end_date", end_date);
        String param = jsonParam.toString();
        HttpRequest rq= new HttpRequest();
        String sr=HttpRequest.sendPost2("https://api.weixin.qq.com/datacube/getupstreammsg?access_token="+str, param);
        return ResultUtil.success(sr);

    }
}
