package com.museum.util;

import java.io.BufferedReader;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.zip.GZIPInputStream;

import net.sf.json.JSONArray;

import net.sf.json.JSONObject;

/**

 * @author ：tjm

 * 通过get请求向网站：http://wthrcdn.etouch.cn/weather_mini 获取某个 城市的天气状况数据，数据格式是Json

 * @date ：Created in 2020/3/9 13:55

 *

 */

public class WeatherUtils {
    private static String weatherUrl = "http://wthrcdn.etouch.cn/weather_mini?city=";

    /**

     * 通过城市名称获取该城市的天气信息

     */

    public static String GetWeatherData(String cityname) {
        StringBuilder sb = new StringBuilder();

        BufferedReader reader = null;

        try {
            URL url = new URL(weatherUrl + cityname);

            URLConnection conn = url.openConnection();

            InputStream is = conn.getInputStream();

            GZIPInputStream gzin = new GZIPInputStream(is);

// 设置读取流的编码格式，自定义编码

            InputStreamReader isr = new InputStreamReader(gzin, "utf-8");

            reader = new BufferedReader(isr);

            String line = null;

            while((line = reader.readLine()) != null){
                sb.append(line + " ");

            }

            reader.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return sb.toString();

    }

    /**

     * 将JSON格式数据进行解析 ，返回一个weather对象

     */

    public static WeatherInfo GetWeather(String weatherInfobyJson){
        JSONObject dataOfJson = JSONObject.fromObject(weatherInfobyJson); // json天气数据

        if(dataOfJson.getInt("status") != 1000){
            return null;

        }

// 创建WeatherInfo对象，提取所需的天气信息

        WeatherInfo weatherInfo = new WeatherInfo();

// 获取当前日期：日期、星期

        Calendar cal = Calendar.getInstance(); // Calendar类的实例化

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日"); // 时间的格式化

        weatherInfo.setDate(sdf1.format(cal.getTime())); // 时间

        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE");

        weatherInfo.setWeek(sdf2.format(cal.getTime())); // 星期

// 从json数据中提取数据：城市、温度、小提醒

        dataOfJson = JSONObject.fromObject(dataOfJson.getString("data"));

        weatherInfo.setCityname(dataOfJson.getString("city")); // 城市

        weatherInfo.setTemp(dataOfJson.getString("wendu")); // 温度

        weatherInfo.setTips(dataOfJson.getString("ganmao")); // 小提示

// 获取今天的天气预报信息：最高温度、最低温度、天气

        JSONArray forecast = dataOfJson.getJSONArray("forecast");

        JSONObject result = forecast.getJSONObject(0);

        weatherInfo.setHighTemp(result.getString("high").substring(2)); // 最高气温

        weatherInfo.setLowTemp(result.getString("low").substring(2)); // 最低气温

        weatherInfo.setWeather(result.getString("type")); // 天气

        return weatherInfo;

    }
    public static void main(String[] args){
        String info = WeatherUtils.GetWeatherData("武侯区");

        System.out.println("1.预测结果：" + info); // 全部天气数据，含预测

        WeatherInfo weatherinfo = WeatherUtils.GetWeather(info);

        System.out.println("2.今天天气：" + weatherinfo.getCityname()); // 当天天气数据

    }

}

