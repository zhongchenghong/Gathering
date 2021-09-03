package com.museum.service.impl;

import com.museum.domain.Industry;
import com.museum.dao.IndustryMapper;
import com.museum.service.IIndustryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 文创产业部产业添加 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Service
public class IndustryServiceImpl extends ServiceImpl<IndustryMapper, Industry> implements IIndustryService {

    @Override
    public  IPage<Industry> findListByPage(Integer page, Integer pageCount){
        IPage<Industry> wherePage = new Page<>(page, pageCount);
        Industry where = new Industry();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Industry industry){
        return baseMapper.insert(industry);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Industry industry){
        return baseMapper.updateById(industry);
    }

    @Override
    public Industry findById(Long id){
        return  baseMapper.selectById(id);
    }
}
