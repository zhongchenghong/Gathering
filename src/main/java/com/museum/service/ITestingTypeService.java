package com.museum.service;

import com.museum.domain.TestingType;
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
public interface ITestingTypeService extends IService<TestingType> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<TestingType>
     */
    IPage<TestingType> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param testingType 
     * @return int
     */
    int add(TestingType testingType);

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
     * @param testingType 
     * @return int
     */
    int updateData(TestingType testingType);

    /**
     * id查询数据
     *
     * @param id id
     * @return TestingType
     */
    TestingType findById(Long id);
}
