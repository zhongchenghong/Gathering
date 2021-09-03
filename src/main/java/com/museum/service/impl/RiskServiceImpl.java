package com.museum.service.impl;

import com.museum.domain.Risk;
import com.museum.dao.RiskMapper;
import com.museum.service.IRiskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 车辆保险险种 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Service
public class RiskServiceImpl extends ServiceImpl<RiskMapper, Risk> implements IRiskService {

    @Override
    public  IPage<Risk> findListByPage(Integer page, Integer pageCount){
        IPage<Risk> wherePage = new Page<>(page, pageCount);
        Risk where = new Risk();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Risk risk){
        return baseMapper.insert(risk);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Risk risk){
        return baseMapper.updateById(risk);
    }

    @Override
    public Risk findById(Long id){
        return  baseMapper.selectById(id);
    }
}
