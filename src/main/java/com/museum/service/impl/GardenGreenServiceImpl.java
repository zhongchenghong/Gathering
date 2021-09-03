package com.museum.service.impl;

import com.museum.domain.GardenGreen;
import com.museum.dao.GardenGreenMapper;
import com.museum.service.IGardenGreenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-12
 */
@Service
public class GardenGreenServiceImpl extends ServiceImpl<GardenGreenMapper, GardenGreen> implements IGardenGreenService {

    @Override
    public  IPage<GardenGreen> findListByPage(Integer page, Integer pageCount){
        IPage<GardenGreen> wherePage = new Page<>(page, pageCount);
        GardenGreen where = new GardenGreen();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(GardenGreen gardenGreen){
        return baseMapper.insert(gardenGreen);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(GardenGreen gardenGreen){
        return baseMapper.updateById(gardenGreen);
    }

    @Override
    public GardenGreen findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<GardenGreen> getGardenGreenCount(String type) {
        return baseMapper.getGardenGreenCount(type);
    }
}
