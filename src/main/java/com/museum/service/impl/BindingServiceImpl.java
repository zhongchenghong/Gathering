package com.museum.service.impl;

import com.museum.domain.Binding;
import com.museum.dao.BindingMapper;
import com.museum.service.IBindingService;
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
 * @since 2021-07-28
 */
@Service
public class BindingServiceImpl extends ServiceImpl<BindingMapper, Binding> implements IBindingService {

    @Override
    public  IPage<Binding> findListByPage(Integer page, Integer pageCount){
        IPage<Binding> wherePage = new Page<>(page, pageCount);
        Binding where = new Binding();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Binding binding){
        return baseMapper.insert(binding);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Binding binding){
        return baseMapper.updateById(binding);
    }

    @Override
    public Binding findById(Long id){
        return  baseMapper.selectById(id);
    }
}
