package com.museum.service.impl;

import com.museum.domain.DeviceManagement;
import com.museum.dao.DeviceManagementMapper;
import com.museum.service.IDeviceManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 信息中心设备管理 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Service
public class DeviceManagementServiceImpl extends ServiceImpl<DeviceManagementMapper, DeviceManagement> implements IDeviceManagementService {

    @Override
    public  IPage<DeviceManagement> findListByPage(Integer page, Integer pageCount){
        IPage<DeviceManagement> wherePage = new Page<>(page, pageCount);
        DeviceManagement where = new DeviceManagement();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(DeviceManagement deviceManagement){
        return baseMapper.insert(deviceManagement);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(DeviceManagement deviceManagement){
        return baseMapper.updateById(deviceManagement);
    }

    @Override
    public DeviceManagement findById(Long id){
        return  baseMapper.selectById(id);
    }
}
