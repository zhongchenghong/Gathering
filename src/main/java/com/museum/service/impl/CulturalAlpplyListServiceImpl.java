package com.museum.service.impl;

import com.museum.domain.CulturalAlpplyList;
import com.museum.dao.CulturalAlpplyListMapper;
import com.museum.service.ICulturalAlpplyListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 子类物品列表 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Service
public class CulturalAlpplyListServiceImpl extends ServiceImpl<CulturalAlpplyListMapper, CulturalAlpplyList> implements ICulturalAlpplyListService {

    @Override
    public  IPage<CulturalAlpplyList> findListByPage(Integer page, Integer pageCount){
        IPage<CulturalAlpplyList> wherePage = new Page<>(page, pageCount);
        CulturalAlpplyList where = new CulturalAlpplyList();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(CulturalAlpplyList culturalAlpplyList){
        return baseMapper.insert(culturalAlpplyList);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(CulturalAlpplyList culturalAlpplyList){
        return baseMapper.updateById(culturalAlpplyList);
    }

    @Override
    public CulturalAlpplyList findById(Long id){
        return  baseMapper.selectById(id);
    }
}
