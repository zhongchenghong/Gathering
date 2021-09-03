package com.museum.service.impl;

import com.museum.domain.GoodsProcess;
import com.museum.dao.GoodsProcessMapper;
import com.museum.service.IGoodsProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 资料采集制作流程表 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Service
public class GoodsProcessServiceImpl extends ServiceImpl<GoodsProcessMapper, GoodsProcess> implements IGoodsProcessService {

    @Override
    public  IPage<GoodsProcess> findListByPage(Integer page, Integer pageCount){
        IPage<GoodsProcess> wherePage = new Page<>(page, pageCount);
        GoodsProcess where = new GoodsProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(GoodsProcess goodsProcess){
        return baseMapper.insert(goodsProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(GoodsProcess goodsProcess){
        return baseMapper.updateById(goodsProcess);
    }

    @Override
    public GoodsProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
