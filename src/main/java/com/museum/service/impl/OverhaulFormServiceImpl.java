package com.museum.service.impl;

import com.museum.domain.OverhaulForm;
import com.museum.dao.OverhaulFormMapper;
import com.museum.service.IOverhaulFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 水电维修维护表单 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
@Service
public class OverhaulFormServiceImpl extends ServiceImpl<OverhaulFormMapper, OverhaulForm> implements IOverhaulFormService {

    @Override
    public  IPage<OverhaulForm> findListByPage(Integer page, Integer pageCount){
        IPage<OverhaulForm> wherePage = new Page<>(page, pageCount);
        OverhaulForm where = new OverhaulForm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(OverhaulForm overhaulForm){
        return baseMapper.insert(overhaulForm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(OverhaulForm overhaulForm){
        return baseMapper.updateById(overhaulForm);
    }

    @Override
    public OverhaulForm findById(Long id){
        return  baseMapper.selectById(id);
    }
}
