package com.museum.service.impl;

import com.museum.domain.GoodsInformation;
import com.museum.dao.GoodsInformationMapper;
import com.museum.service.IGoodsInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 信息中心录入物品名称 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
@Service
public class GoodsInformationServiceImpl extends ServiceImpl<GoodsInformationMapper, GoodsInformation> implements IGoodsInformationService {

    @Override
    public  IPage<GoodsInformation> findListByPage(Integer page, Integer pageCount){
        IPage<GoodsInformation> wherePage = new Page<>(page, pageCount);
        GoodsInformation where = new GoodsInformation();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(GoodsInformation goodsInformation){
        return baseMapper.insert(goodsInformation);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(GoodsInformation goodsInformation){
        return baseMapper.updateById(goodsInformation);
    }

    @Override
    public GoodsInformation findById(Long id){
        return  baseMapper.selectById(id);
    }
}
