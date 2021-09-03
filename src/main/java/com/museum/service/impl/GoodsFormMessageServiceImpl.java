package com.museum.service.impl;

import com.museum.domain.GoodsFormMessage;
import com.museum.dao.GoodsFormMessageMapper;
import com.museum.service.IGoodsFormMessageService;
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
 * @since 2021-08-17
 */
@Service
public class GoodsFormMessageServiceImpl extends ServiceImpl<GoodsFormMessageMapper, GoodsFormMessage> implements IGoodsFormMessageService {

    @Override
    public  IPage<GoodsFormMessage> findListByPage(Integer page, Integer pageCount){
        IPage<GoodsFormMessage> wherePage = new Page<>(page, pageCount);
        GoodsFormMessage where = new GoodsFormMessage();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(GoodsFormMessage goodsFormMessage){
        return baseMapper.insert(goodsFormMessage);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(GoodsFormMessage goodsFormMessage){
        return baseMapper.updateById(goodsFormMessage);
    }

    @Override
    public GoodsFormMessage findById(Long id){
        return  baseMapper.selectById(id);
    }
}
