package com.museum.controller.weixin;

import com.museum.common.HttpRequest;
import com.museum.common.ResultUtil;
import org.json.JSONObject;

/**
 * 公众号发送文章
 * @author lsj
 */
public class ServiceWeixinController {

    //获取accessToken
    public static String getaccessToken(){
        String sr=HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/token", "grant_type=client_credential&appid=wx9305afd2f3216e48&secret=b27928e95f7fdee34c13e99a1d0cdcf0");
        JSONObject jsonObj = new JSONObject(sr);
        Object age =jsonObj.get("access_token");
        String access_token=age.toString();
        return access_token;
    }

    public static void main(String[] args) {
        String str=  getaccessToken();
        System.out.println("-----------------:"+str);
    }

    /**
     * 通过模板编号，获取模板id
     * template_id_short 模板编号
     * template_id模板id
     */
    public String  getTemplateId(String template_id_short){
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("template_id_short", template_id_short);
        String param = jsonParam.toString();
        HttpRequest rq= new HttpRequest();
        String sr=HttpRequest.sendPost2("https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token="+getaccessToken(), param);
        JSONObject jsonParams = new JSONObject();
        net.sf.json.JSONObject json =net.sf.json.JSONObject.fromObject(sr);
        String str=json.getString("template_id");
        return sr;
    }

    /**
     * 下发消息
     * 参数
     *         jsonParam.put("touser", touser);
     *         jsonParam.put("template_id", template_id);
     *         jsonParam.put("url", http://weixin.qq.com/download);
     *         JSONObject json1 = new JSONObject();
     *         json1.put("appid",appid);
     *         json1.put("pagepath",pagepath);
     *         jsonParam.put("miniprogram", json1);
     *         JSONObject json2 = new JSONObject();
     *         json2.put("appid","");
     *         jsonParam.put("data", json2);
     *
     *         jsonParam.put("touser", template_id_short);
     */
    public void postMessage(JSONObject jsonParam){
        String param = jsonParam.toString();
        HttpRequest rq= new HttpRequest();
        String sr=HttpRequest.sendPost2("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+getaccessToken(), param);
        System.out.println("sr:"+sr);
    }
}
