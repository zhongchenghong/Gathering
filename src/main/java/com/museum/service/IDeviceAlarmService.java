package com.museum.service;

import com.museum.domain.AlarmMessage;
import com.museum.domain.DeviceAlarm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
public interface IDeviceAlarmService extends IService<DeviceAlarm> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<DeviceAlarm>
     */
    IPage<DeviceAlarm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param deviceAlarm 
     * @return int
     */
    int add(DeviceAlarm deviceAlarm);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param deviceAlarm 
     * @return int
     */
    int updateData(DeviceAlarm deviceAlarm);

    /**
     * id查询数据
     *
     * @param id id
     * @return DeviceAlarm
     */
    DeviceAlarm findById(Long id);

    /**
     * 获取设备告警信息
     * @return
     */
    List<AlarmMessage> getalarm();
}
