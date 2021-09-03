package com.museum.service.impl;

import com.museum.domain.ImmovableData;
import com.museum.dao.ImmovableDataMapper;
import com.museum.service.IImmovableDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-不可移动文物数据 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Service
public class ImmovableDataServiceImpl extends ServiceImpl<ImmovableDataMapper, ImmovableData> implements IImmovableDataService {

    @Override
    public  IPage<ImmovableData> findListByPage(Integer page, Integer pageCount){
        IPage<ImmovableData> wherePage = new Page<>(page, pageCount);
        ImmovableData where = new ImmovableData();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ImmovableData immovableData){
        return baseMapper.insert(immovableData);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ImmovableData immovableData){
        return baseMapper.updateById(immovableData);
    }

    @Override
    public ImmovableData findById(Long id){
        return  baseMapper.selectById(id);
    }
}
