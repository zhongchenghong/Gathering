package com.museum.service.impl;

import com.museum.domain.Releases;
import com.museum.dao.ReleasesMapper;
import com.museum.service.IReleasesService;
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
 * @since 2021-06-08
 */
@Service
public class ReleasesServiceImpl extends ServiceImpl<ReleasesMapper, Releases> implements IReleasesService {

    @Override
    public  IPage<Releases> findListByPage(Integer page, Integer pageCount){
        IPage<Releases> wherePage = new Page<>(page, pageCount);
        Releases where = new Releases();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Releases releases){
        return baseMapper.insert(releases);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Releases releases){
        return baseMapper.updateById(releases);
    }

    @Override
    public Releases findById(Long id){
        return  baseMapper.selectById(id);
    }
}
