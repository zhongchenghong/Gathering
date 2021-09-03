package com.museum.service.impl;

import com.museum.domain.SealForm;
import com.museum.dao.SealFormMapper;
import com.museum.service.ISealFormService;
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
public class SealFormServiceImpl extends ServiceImpl<SealFormMapper, SealForm> implements ISealFormService {

    @Override
    public  IPage<SealForm> findListByPage(Integer page, Integer pageCount){
        IPage<SealForm> wherePage = new Page<>(page, pageCount);
        SealForm where = new SealForm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(SealForm sealForm){
        return baseMapper.insert(sealForm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(SealForm sealForm){
        return baseMapper.updateById(sealForm);
    }

    @Override
    public SealForm findById(Long id){
        return  baseMapper.selectById(id);
    }
}
