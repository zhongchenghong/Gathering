package com.museum.service.impl;

import com.museum.domain.MapPoints;
import com.museum.dao.MapPointsMapper;
import com.museum.service.IMapPointsService;
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
 * @since 2021-06-24
 */
@Service
public class MapPointsServiceImpl extends ServiceImpl<MapPointsMapper, MapPoints> implements IMapPointsService {

    @Override
    public  IPage<MapPoints> findListByPage(Integer page, Integer pageCount){
        IPage<MapPoints> wherePage = new Page<>(page, pageCount);
        MapPoints where = new MapPoints();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(MapPoints mapPoints){
        return baseMapper.insert(mapPoints);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(MapPoints mapPoints){
        return baseMapper.updateById(mapPoints);
    }

    @Override
    public MapPoints findById(Long id){
        return  baseMapper.selectById(id);
    }
}
