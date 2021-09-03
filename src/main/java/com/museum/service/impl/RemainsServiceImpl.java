package com.museum.service.impl;

import com.museum.domain.Remains;
import com.museum.dao.RemainsMapper;
import com.museum.service.IRemainsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-遗存调查数据 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Service
public class RemainsServiceImpl extends ServiceImpl<RemainsMapper, Remains> implements IRemainsService {

    @Override
    public  IPage<Remains> findListByPage(Integer page, Integer pageCount){
        IPage<Remains> wherePage = new Page<>(page, pageCount);
        Remains where = new Remains();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Remains remains){
        return baseMapper.insert(remains);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Remains remains){
        return baseMapper.updateById(remains);
    }

    @Override
    public Remains findById(Long id){
        return  baseMapper.selectById(id);
    }
}
