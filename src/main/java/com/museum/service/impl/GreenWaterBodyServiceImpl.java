package com.museum.service.impl;

import com.museum.domain.GreenWaterBody;
import com.museum.dao.GreenWaterBodyMapper;
import com.museum.service.IGreenWaterBodyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-绿地水体面积 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Service
public class GreenWaterBodyServiceImpl extends ServiceImpl<GreenWaterBodyMapper, GreenWaterBody> implements IGreenWaterBodyService {

    @Override
    public  IPage<GreenWaterBody> findListByPage(Integer page, Integer pageCount){
        IPage<GreenWaterBody> wherePage = new Page<>(page, pageCount);
        GreenWaterBody where = new GreenWaterBody();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(GreenWaterBody greenWaterBody){
        return baseMapper.insert(greenWaterBody);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(GreenWaterBody greenWaterBody){
        return baseMapper.updateById(greenWaterBody);
    }

    @Override
    public GreenWaterBody findById(Long id){
        return  baseMapper.selectById(id);
    }
}
