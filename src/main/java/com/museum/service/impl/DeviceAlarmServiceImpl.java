package com.museum.service.impl;

import com.museum.domain.AlarmMessage;
import com.museum.domain.DeviceAlarm;
import com.museum.dao.DeviceAlarmMapper;
import com.museum.service.IDeviceAlarmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Service
public class DeviceAlarmServiceImpl extends ServiceImpl<DeviceAlarmMapper, DeviceAlarm> implements IDeviceAlarmService {

    @Override
    public  IPage<DeviceAlarm> findListByPage(Integer page, Integer pageCount){
        IPage<DeviceAlarm> wherePage = new Page<>(page, pageCount);
        DeviceAlarm where = new DeviceAlarm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(DeviceAlarm deviceAlarm){
        return baseMapper.insert(deviceAlarm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(DeviceAlarm deviceAlarm){
        return baseMapper.updateById(deviceAlarm);
    }

    @Override
    public DeviceAlarm findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<AlarmMessage> getalarm() {
        return baseMapper.getalarm();
    }
}
