package com.museum.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonTool {
    public static void main(String[] args) throws JSONException {
        //记得转义，因为最外层已经是"",里面的""要转义
        String jsonStr="{\"list\":[{ \"ref_date\": \"2014-12-07\", \"ref_hour\": 0, \"msg_type\": 1, \"msg_user\": 9, \"msg_count\": 10 }]}";
        JSONObject jsonObj = new JSONObject(jsonStr);
        Object age = jsonObj.get("list");
        System.out.println("-----------:"+age);
    }

}