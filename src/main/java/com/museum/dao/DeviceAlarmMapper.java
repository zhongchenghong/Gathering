package com.museum.dao;

import com.museum.domain.AlarmMessage;
import com.museum.domain.DeviceAlarm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
public interface DeviceAlarmMapper extends BaseMapper<DeviceAlarm> {

    @Select("select device_alarm.createtimes as createtimes,device_alarm.state as  state,\n" +
            "device_alarm.events as  events,device_management.address as address,device_management.type\n" +
            "from device_alarm \n" +
            "LEFT JOIN device_management on device_alarm.device_num=device_management.number ")
    List<AlarmMessage> getalarm();
}
