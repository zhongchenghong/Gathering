package com.museum.service.impl;

import com.museum.domain.TestingType;
import com.museum.dao.TestingTypeMapper;
import com.museum.service.ITestingTypeService;
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
public class TestingTypeServiceImpl extends ServiceImpl<TestingTypeMapper, TestingType> implements ITestingTypeService {

    @Override
    public  IPage<TestingType> findListByPage(Integer page, Integer pageCount){
        IPage<TestingType> wherePage = new Page<>(page, pageCount);
        TestingType where = new TestingType();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(TestingType testingType){
        return baseMapper.insert(testingType);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(TestingType testingType){
        return baseMapper.updateById(testingType);
    }

    @Override
    public TestingType findById(Long id){
        return  baseMapper.selectById(id);
    }
}
