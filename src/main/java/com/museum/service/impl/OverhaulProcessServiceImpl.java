package com.museum.service.impl;

import com.museum.domain.OverhaulProcess;
import com.museum.dao.OverhaulProcessMapper;
import com.museum.service.IOverhaulProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 水电维修维护申请流程 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
@Service
public class OverhaulProcessServiceImpl extends ServiceImpl<OverhaulProcessMapper, OverhaulProcess> implements IOverhaulProcessService {

    @Override
    public  IPage<OverhaulProcess> findListByPage(Integer page, Integer pageCount){
        IPage<OverhaulProcess> wherePage = new Page<>(page, pageCount);
        OverhaulProcess where = new OverhaulProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(OverhaulProcess overhaulProcess){
        return baseMapper.insert(overhaulProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(OverhaulProcess overhaulProcess){
        return baseMapper.updateById(overhaulProcess);
    }

    @Override
    public OverhaulProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
