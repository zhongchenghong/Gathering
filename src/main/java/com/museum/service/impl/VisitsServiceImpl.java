package com.museum.service.impl;

import com.museum.domain.Visits;
import com.museum.dao.VisitsMapper;
import com.museum.service.IVisitsService;
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
public class VisitsServiceImpl extends ServiceImpl<VisitsMapper, Visits> implements IVisitsService {

    @Override
    public  IPage<Visits> findListByPage(Integer page, Integer pageCount){
        IPage<Visits> wherePage = new Page<>(page, pageCount);
        Visits where = new Visits();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Visits visits){
        return baseMapper.insert(visits);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Visits visits){
        return baseMapper.updateById(visits);
    }

    @Override
    public Visits findById(Long id){
        return  baseMapper.selectById(id);
    }
}
