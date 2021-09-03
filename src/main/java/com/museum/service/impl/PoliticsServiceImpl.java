package com.museum.service.impl;

import com.museum.domain.Politics;
import com.museum.dao.PoliticsMapper;
import com.museum.service.IPoliticsService;
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
public class PoliticsServiceImpl extends ServiceImpl<PoliticsMapper, Politics> implements IPoliticsService {

    @Override
    public  IPage<Politics> findListByPage(Integer page, Integer pageCount){
        IPage<Politics> wherePage = new Page<>(page, pageCount);
        Politics where = new Politics();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Politics politics){
        return baseMapper.insert(politics);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Politics politics){
        return baseMapper.updateById(politics);
    }

    @Override
    public Politics findById(Long id){
        return  baseMapper.selectById(id);
    }
}
