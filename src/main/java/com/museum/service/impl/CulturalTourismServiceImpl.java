package com.museum.service.impl;

import com.museum.domain.CulturalTourism;
import com.museum.dao.CulturalTourismMapper;
import com.museum.service.ICulturalTourismService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-文旅数据上报 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Service
public class CulturalTourismServiceImpl extends ServiceImpl<CulturalTourismMapper, CulturalTourism> implements ICulturalTourismService {

    @Override
    public  IPage<CulturalTourism> findListByPage(Integer page, Integer pageCount){
        IPage<CulturalTourism> wherePage = new Page<>(page, pageCount);
        CulturalTourism where = new CulturalTourism();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(CulturalTourism culturalTourism){
        return baseMapper.insert(culturalTourism);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(CulturalTourism culturalTourism){
        return baseMapper.updateById(culturalTourism);
    }

    @Override
    public CulturalTourism findById(Long id){
        return  baseMapper.selectById(id);
    }
}
