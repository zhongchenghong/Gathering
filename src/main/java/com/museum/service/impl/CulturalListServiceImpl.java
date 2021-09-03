package com.museum.service.impl;

import com.museum.domain.CulturalList;
import com.museum.dao.CulturalListMapper;
import com.museum.service.ICulturalListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 物品列表 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Service
public class CulturalListServiceImpl extends ServiceImpl<CulturalListMapper, CulturalList> implements ICulturalListService {

    @Override
    public  IPage<CulturalList> findListByPage(Integer page, Integer pageCount){
        IPage<CulturalList> wherePage = new Page<>(page, pageCount);
        CulturalList where = new CulturalList();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(CulturalList culturalList){
        return baseMapper.insert(culturalList);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(CulturalList culturalList){
        return baseMapper.updateById(culturalList);
    }

    @Override
    public CulturalList findById(Long id){
        return  baseMapper.selectById(id);
    }
}
