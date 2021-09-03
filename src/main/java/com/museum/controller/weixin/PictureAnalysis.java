package com.museum.controller.weixin;

import com.museum.common.HttpRequest;

public class PictureAnalysis {
    public String getuserread(){
        HttpRequest rq= new HttpRequest();
        String sr=HttpRequest.sendPost("https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN",
                "begin_date=123&end_date=456");
        System.out.println(sr);
        return sr;

    }
}
