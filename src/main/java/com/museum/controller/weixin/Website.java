package com.museum.controller.weixin;

import com.museum.common.HttpRequest;
import org.json.JSONObject;

public class Website {
    public void web(){
        HttpRequest rq= new HttpRequest();
        String sr=HttpRequest.sendGet("http://openapi.baidu.com/oauth/2.0/token?grant_type=authorization_code&code={CODE}&client_id={CLIENT_ID}&client_secret={CLIENT_SECRET}&redirect_uri={REDIRECT_URI}", "grant_type=client_credential&appid=wx9305afd2f3216e48&secret=b27928e95f7fdee34c13e99a1d0cdcf0");
        JSONObject jsonObj = new JSONObject(sr);
        Object age =jsonObj.get("access_token");
    }
}
