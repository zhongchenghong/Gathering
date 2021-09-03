package com.museum.service.impl;

import com.museum.domain.GardenPlants;
import com.museum.dao.GardenPlantsMapper;
import com.museum.service.IGardenPlantsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 园林景观-新增植物 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-12
 */
@Service
public class GardenPlantsServiceImpl extends ServiceImpl<GardenPlantsMapper, GardenPlants> implements IGardenPlantsService {

    @Override
    public  IPage<GardenPlants> findListByPage(Integer page, Integer pageCount){
        IPage<GardenPlants> wherePage = new Page<>(page, pageCount);
        GardenPlants where = new GardenPlants();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(GardenPlants gardenPlants){
        return baseMapper.insert(gardenPlants);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(GardenPlants gardenPlants){
        return baseMapper.updateById(gardenPlants);
    }

    @Override
    public GardenPlants findById(Long id){
        return  baseMapper.selectById(id);
    }
}
