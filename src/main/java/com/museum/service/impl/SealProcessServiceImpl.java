package com.museum.service.impl;

import com.museum.domain.SealProcess;
import com.museum.dao.SealProcessMapper;
import com.museum.service.ISealProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 用章流程 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-26
 */
@Service
public class SealProcessServiceImpl extends ServiceImpl<SealProcessMapper, SealProcess> implements ISealProcessService {

    @Override
    public  IPage<SealProcess> findListByPage(Integer page, Integer pageCount){
        IPage<SealProcess> wherePage = new Page<>(page, pageCount);
        SealProcess where = new SealProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(SealProcess sealProcess){
        return baseMapper.insert(sealProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(SealProcess sealProcess){
        return baseMapper.updateById(sealProcess);
    }

    @Override
    public SealProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
