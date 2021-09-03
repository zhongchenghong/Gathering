package com.museum.service.impl;

import com.museum.domain.Reception;
import com.museum.dao.ReceptionMapper;
import com.museum.service.IReceptionService;
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
 * @since 2021-07-21
 */
@Service
public class ReceptionServiceImpl extends ServiceImpl<ReceptionMapper, Reception> implements IReceptionService {

    @Override
    public  IPage<Reception> findListByPage(Integer page, Integer pageCount){
        IPage<Reception> wherePage = new Page<>(page, pageCount);
        Reception where = new Reception();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Reception reception){
        return baseMapper.insert(reception);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Reception reception){
        return baseMapper.updateById(reception);
    }

    @Override
    public Reception findById(Long id){
        return  baseMapper.selectById(id);
    }
}
