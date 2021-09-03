package com.museum.controller;

import com.museum.domain.VisitsName;
import com.museum.util.WeatherInfo;
import com.museum.util.WeatherUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-15
 */
@Api(tags = {"获取武侯区天气"})
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @ApiOperation(value = "获取武侯区天气")
    @PostMapping("/getweather")
    public String  getweather(){
        String info = WeatherUtils.GetWeatherData("武侯区");
        WeatherInfo weatherinfo = WeatherUtils.GetWeather(info);
        return  weatherinfo.getCityname();
    }
}
