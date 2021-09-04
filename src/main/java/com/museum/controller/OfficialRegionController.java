package com.museum.controller;

import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.util.HttpsUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取官网访问量(地区趋势数据)
 */
@RestController
@RequestMapping("/officialregion")
@Api(tags = {"获取官网访问量(地区趋势数据)"})
public class OfficialRegionController {

    @ApiOperation(value = "获取官网访问量地区趋势数据")
    @PostMapping(value = "/getregion")
    public Result getoffical(String start_date, String end_date){

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
            body.put("method","overview/getDistrictRpt");//需要获取的数据
            body.put("start_date",start_date);
            body.put("end_date",end_date);
            body.put("metrics","pv_count");//指标,数据单位
            body.put("gran","day");
            JSONObject params = new JSONObject();
            params.put("header", header);
            params.put("body", body);
            byte[] res = HttpsUtil.post(urlStr, params.toString(), charset);
            s = new String(res);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.success(s);
    }

}
