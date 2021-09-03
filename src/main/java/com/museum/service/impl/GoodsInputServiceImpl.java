package com.museum.service.impl;

import com.museum.domain.GoodsInput;
import com.museum.dao.GoodsInputMapper;
import com.museum.service.IGoodsInputService;
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
 * @since 2021-08-16
 */
@Service
public class GoodsInputServiceImpl extends ServiceImpl<GoodsInputMapper, GoodsInput> implements IGoodsInputService {

    @Override
    public  IPage<GoodsInput> findListByPage(Integer page, Integer pageCount){
        IPage<GoodsInput> wherePage = new Page<>(page, pageCount);
        GoodsInput where = new GoodsInput();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(GoodsInput goodsInput){
        return baseMapper.insert(goodsInput);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(GoodsInput goodsInput){
        return baseMapper.updateById(goodsInput);
    }

    @Override
    public GoodsInput findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public String totail() {
        return baseMapper.totail();
    }

    @Override
    public String selectBytype(String type) {
        return baseMapper.selectBytype(type);
    }
}
