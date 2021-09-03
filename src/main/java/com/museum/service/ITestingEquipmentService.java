package com.museum.service;

import com.museum.domain.TestingEquipment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 保护信息管理系统设备管理 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-04
 */
public interface ITestingEquipmentService extends IService<TestingEquipment> {

    /**
     * 查询保护信息管理系统设备管理分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<TestingEquipment>
     */
    IPage<TestingEquipment> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加保护信息管理系统设备管理
     *
     * @param testingEquipment 保护信息管理系统设备管理
     * @return int
     */
    int add(TestingEquipment testingEquipment);

    /**
     * 删除保护信息管理系统设备管理
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改保护信息管理系统设备管理
     *
     * @param testingEquipment 保护信息管理系统设备管理
     * @return int
     */
    int updateData(TestingEquipment testingEquipment);

    /**
     * id查询数据
     *
     * @param id id
     * @return TestingEquipment
     */
    TestingEquipment findById(Long id);
}
