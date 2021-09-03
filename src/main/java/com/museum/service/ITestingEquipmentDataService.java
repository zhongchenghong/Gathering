package com.museum.service;

import com.museum.domain.TestingEquipmentData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-05
 */
public interface ITestingEquipmentDataService extends IService<TestingEquipmentData> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<TestingEquipmentData>
     */
    IPage<TestingEquipmentData> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param testingEquipmentData 
     * @return int
     */
    int add(TestingEquipmentData testingEquipmentData);

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
     * @param testingEquipmentData 
     * @return int
     */
    int updateData(TestingEquipmentData testingEquipmentData);

    /**
     * id查询数据
     *
     * @param id id
     * @return TestingEquipmentData
     */
    TestingEquipmentData findById(Long id);
}
