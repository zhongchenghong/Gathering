package com.museum.service.impl;

import com.museum.domain.TestingEquipmentData;
import com.museum.dao.TestingEquipmentDataMapper;
import com.museum.service.ITestingEquipmentDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-05
 */
@Service
public class TestingEquipmentDataServiceImpl extends ServiceImpl<TestingEquipmentDataMapper, TestingEquipmentData> implements ITestingEquipmentDataService {

    @Override
    public  IPage<TestingEquipmentData> findListByPage(Integer page, Integer pageCount){
        IPage<TestingEquipmentData> wherePage = new Page<>(page, pageCount);
        TestingEquipmentData where = new TestingEquipmentData();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(TestingEquipmentData testingEquipmentData){
        return baseMapper.insert(testingEquipmentData);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(TestingEquipmentData testingEquipmentData){
        return baseMapper.updateById(testingEquipmentData);
    }

    @Override
    public TestingEquipmentData findById(Long id){
        return  baseMapper.selectById(id);
    }
}
