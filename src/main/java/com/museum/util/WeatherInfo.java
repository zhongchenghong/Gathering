package com.museum.util;

import lombok.Data;

@Data
public class WeatherInfo {
    private String date; //时间

    private String week; //星期

    private String lunar; //农历时间

    private String cityname; //城市名

    private String weather; //天气

    private String temp; //当前温度

    private String highTemp; //最低温度

    private String lowTemp; //当前温度

    private String tips; //小提示


}
