package com.museum.service.impl;

import com.museum.domain.DataCollectionProcess;
import com.museum.dao.DataCollectionProcessMapper;
import com.museum.service.IDataCollectionProcessService;
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
public class DataCollectionProcessServiceImpl extends ServiceImpl<DataCollectionProcessMapper, DataCollectionProcess> implements IDataCollectionProcessService {

    @Override
    public  IPage<DataCollectionProcess> findListByPage(Integer page, Integer pageCount){
        IPage<DataCollectionProcess> wherePage = new Page<>(page, pageCount);
        DataCollectionProcess where = new DataCollectionProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(DataCollectionProcess dataCollectionProcess){
        return baseMapper.insert(dataCollectionProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(DataCollectionProcess dataCollectionProcess){
        return baseMapper.updateById(dataCollectionProcess);
    }

    @Override
    public DataCollectionProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
