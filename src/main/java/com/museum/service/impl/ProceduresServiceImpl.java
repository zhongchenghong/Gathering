package com.museum.service.impl;

import com.museum.domain.Procedures;
import com.museum.dao.ProceduresMapper;
import com.museum.service.IProceduresService;
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
public class ProceduresServiceImpl extends ServiceImpl<ProceduresMapper, Procedures> implements IProceduresService {

    @Override
    public  IPage<Procedures> findListByPage(Integer page, Integer pageCount){
        IPage<Procedures> wherePage = new Page<>(page, pageCount);
        Procedures where = new Procedures();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Procedures procedures){
        return baseMapper.insert(procedures);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Procedures procedures){
        return baseMapper.updateById(procedures);
    }

    @Override
    public Procedures findById(Long id){
        return  baseMapper.selectById(id);
    }
}
