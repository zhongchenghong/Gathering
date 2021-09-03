package com.museum.controller;

import com.alibaba.fastjson.JSON;
import com.museum.common.HttpRequest;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.util.HttpsUtil;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取官网访问量(趋势数据)
 */
@RestController
@RequestMapping("/official")
@ApiOperation(value = "获取官网访问量(趋势数据)")
public class OfficialController {

    @ApiOperation(value = "获取官网访问量")
    @PostMapping(value = "/getoffical")
    public static  Result getoffical(String start_date,String end_date){

        String sr = null;
        try {
            JSONObject header = new JSONObject();
            header.put("username", "成都武侯祠博物馆");//用户名
            header.put("password", " cdwhc85550224");//用户密码
            header.put("token", "ff863f838e8ecb69876f8987b0ed4561");//申请到的token
            header.put("account_type", "1");

            String urlStr = "https://api.baidu.com/json/tongji/v1/ReportService/getData";
            String charset = "utf-8";
            JSONObject body = new JSONObject();
            body.put("siteId","10972827");
            body.put("method","visit/world/a");//需要获取的数据
            body.put("start_date",start_date);
            body.put("end_date",end_date);
            body.put("metrics","pv_count,visitor_count,avg_visit_time");//指标,数据单位
            body.put("gran","day");
            JSONObject params = new JSONObject();
            params.put("header", header);
            params.put("body", body);
            byte[] res = HttpsUtil.post(urlStr, params.toString(), charset);
            sr = new String(res);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.success(sr);
    }

    @ApiOperation(value = "获取国家访问量")
    @PostMapping(value = "/getCountryCount")
    public static  Result getCountryCount(String start_date,String end_date){

        String s = null;
        try {
            JSONObject header = new JSONObject();
            header.put("username", "成都武侯祠博物馆");//用户名
            header.put("password", " cdwhc85550224");//用户密码
            header.put("token", "ff863f838e8ecb69876f8987b0ed4561");//申请到的token
            header.put("account_type", "1");

            String urlStr = "https://api.baidu.com/json/tongji/v1/ReportService/getData";
            String charset = "utf-8";
            JSONObject body = new JSONObject();
            body.put("siteId","10972827");
            body.put("method","visit/world/a");//需要获取的数据
            body.put("start_date",start_date);
            body.put("end_date",end_date);
            body.put("metrics","pv_count,visit_count,visitor_count");//指标,数据单位

            JSONObject params = new JSONObject();
            params.put("header", header);
            params.put("body", body);
            byte[] res = HttpsUtil.post(urlStr, params.toString(), charset);
            s = new String(res);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
        return ResultUtil.success(s);
    }

    @ApiOperation(value = "获取单个页面访问量")
    @PostMapping(value = "/getpageCount")
    public static  Result getpageCount(String start_date,String end_date){

        String s = null;
        try {
            JSONObject header = new JSONObject();
            header.put("username", "成都武侯祠博物馆");//用户名
            header.put("password", " cdwhc85550224");//用户密码
            header.put("token", "ff863f838e8ecb69876f8987b0ed4561");//申请到的token
            header.put("account_type", "1");

            String urlStr = "https://api.baidu.com/json/tongji/v1/ReportService/getData";
            String charset = "utf-8";
            JSONObject body = new JSONObject();
            body.put("siteId","10972827");
            body.put("method","visit/landingpage/a");//需要获取的数据
            body.put("start_date",start_date);
            body.put("end_date",end_date);
            body.put("metrics","visit_count,visitor_count,new_visitor_count");//指标,数据单位

            JSONObject params = new JSONObject();
            params.put("header", header);
            params.put("body", body);
            byte[] res = HttpsUtil.post(urlStr, params.toString(), charset);
            s = new String(res);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
        return ResultUtil.success(s);
    }

    }


