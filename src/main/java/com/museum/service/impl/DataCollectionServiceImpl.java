package com.museum.service.impl;

import com.museum.domain.DataCollection;
import com.museum.dao.DataCollectionMapper;
import com.museum.service.IDataCollectionService;
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
 * @since 2021-07-20
 */
@Service
public class DataCollectionServiceImpl extends ServiceImpl<DataCollectionMapper, DataCollection> implements IDataCollectionService {

    @Override
    public  IPage<DataCollection> findListByPage(Integer page, Integer pageCount){
        IPage<DataCollection> wherePage = new Page<>(page, pageCount);
        DataCollection where = new DataCollection();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(DataCollection dataCollection){
        return baseMapper.insert(dataCollection);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(DataCollection dataCollection){
        return baseMapper.updateById(dataCollection);
    }

    @Override
    public DataCollection findById(Long id){
        return  baseMapper.selectById(id);
    }
}
