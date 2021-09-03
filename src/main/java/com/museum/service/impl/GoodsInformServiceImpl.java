package com.museum.service.impl;

import com.museum.domain.GoodsInform;
import com.museum.dao.GoodsInformMapper;
import com.museum.service.IGoodsInformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 物品领用 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Service
public class GoodsInformServiceImpl extends ServiceImpl<GoodsInformMapper, GoodsInform> implements IGoodsInformService {

    @Override
    public  IPage<GoodsInform> findListByPage(Integer page, Integer pageCount){
        IPage<GoodsInform> wherePage = new Page<>(page, pageCount);
        GoodsInform where = new GoodsInform();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(GoodsInform goodsInform){
        return baseMapper.insert(goodsInform);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(GoodsInform goodsInform){
        return baseMapper.updateById(goodsInform);
    }

    @Override
    public GoodsInform findById(Long id){
        return  baseMapper.selectById(id);
    }
}
