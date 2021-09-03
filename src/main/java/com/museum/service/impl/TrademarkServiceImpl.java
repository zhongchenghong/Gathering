package com.museum.service.impl;

import com.museum.domain.Trademark;
import com.museum.dao.TrademarkMapper;
import com.museum.service.ITrademarkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 文创产业部商标添加 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Service
public class TrademarkServiceImpl extends ServiceImpl<TrademarkMapper, Trademark> implements ITrademarkService {

    @Override
    public  IPage<Trademark> findListByPage(Integer page, Integer pageCount){
        IPage<Trademark> wherePage = new Page<>(page, pageCount);
        Trademark where = new Trademark();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Trademark trademark){
        return baseMapper.insert(trademark);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Trademark trademark){
        return baseMapper.updateById(trademark);
    }

    @Override
    public Trademark findById(Long id){
        return  baseMapper.selectById(id);
    }
}
