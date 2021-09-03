package com.museum.service;

import com.museum.domain.DeviceManagement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 信息中心设备管理 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
public interface IDeviceManagementService extends IService<DeviceManagement> {

    /**
     * 查询信息中心设备管理分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<DeviceManagement>
     */
    IPage<DeviceManagement> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加信息中心设备管理
     *
     * @param deviceManagement 信息中心设备管理
     * @return int
     */
    int add(DeviceManagement deviceManagement);

    /**
     * 删除信息中心设备管理
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改信息中心设备管理
     *
     * @param deviceManagement 信息中心设备管理
     * @return int
     */
    int updateData(DeviceManagement deviceManagement);

    /**
     * id查询数据
     *
     * @param id id
     * @return DeviceManagement
     */
    DeviceManagement findById(Long id);
}
