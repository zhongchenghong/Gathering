package com.museum.service.impl;

import com.museum.domain.InternalControl;
import com.museum.dao.InternalControlMapper;
import com.museum.service.IInternalControlService;
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
 * @since 2021-07-09
 */
@Service
public class InternalControlServiceImpl extends ServiceImpl<InternalControlMapper, InternalControl> implements IInternalControlService {

    @Override
    public  IPage<InternalControl> findListByPage(Integer page, Integer pageCount){
        IPage<InternalControl> wherePage = new Page<>(page, pageCount);
        InternalControl where = new InternalControl();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(InternalControl internalControl){
        return baseMapper.insert(internalControl);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(InternalControl internalControl){
        return baseMapper.updateById(internalControl);
    }

    @Override
    public InternalControl findById(Long id){
        return  baseMapper.selectById(id);
    }
}
