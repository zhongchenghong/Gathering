package com.museum.service.impl;

import com.museum.domain.TestingEquipment;
import com.museum.dao.TestingEquipmentMapper;
import com.museum.service.ITestingEquipmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 保护信息管理系统设备管理 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-04
 */
@Service
public class TestingEquipmentServiceImpl extends ServiceImpl<TestingEquipmentMapper, TestingEquipment> implements ITestingEquipmentService {

    @Override
    public  IPage<TestingEquipment> findListByPage(Integer page, Integer pageCount){
        IPage<TestingEquipment> wherePage = new Page<>(page, pageCount);
        TestingEquipment where = new TestingEquipment();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(TestingEquipment testingEquipment){
        return baseMapper.insert(testingEquipment);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(TestingEquipment testingEquipment){
        return baseMapper.updateById(testingEquipment);
    }

    @Override
    public TestingEquipment findById(Long id){
        return  baseMapper.selectById(id);
    }
}
