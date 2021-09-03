package com.museum.service.impl;

import com.museum.domain.VisitsName;
import com.museum.dao.VisitsNameMapper;
import com.museum.service.IVisitsNameService;
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
 * @since 2021-07-15
 */
@Service
public class VisitsNameServiceImpl extends ServiceImpl<VisitsNameMapper, VisitsName> implements IVisitsNameService {

    @Override
    public  IPage<VisitsName> findListByPage(Integer page, Integer pageCount){
        IPage<VisitsName> wherePage = new Page<>(page, pageCount);
        VisitsName where = new VisitsName();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(VisitsName visitsName){
        return baseMapper.insert(visitsName);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(VisitsName visitsName){
        return baseMapper.updateById(visitsName);
    }

    @Override
    public VisitsName findById(Long id){
        return  baseMapper.selectById(id);
    }
}
