package com.museum.service.impl;

import com.museum.domain.Jlleader;
import com.museum.dao.JlleaderMapper;
import com.museum.service.IJlleaderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 锦里公司领导组件 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
@Service
public class JlleaderServiceImpl extends ServiceImpl<JlleaderMapper, Jlleader> implements IJlleaderService {

    @Override
    public  IPage<Jlleader> findListByPage(Integer page, Integer pageCount){
        IPage<Jlleader> wherePage = new Page<>(page, pageCount);
        Jlleader where = new Jlleader();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Jlleader jlleader){
        return baseMapper.insert(jlleader);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Jlleader jlleader){
        return baseMapper.updateById(jlleader);
    }

    @Override
    public Jlleader findById(Long id){
        return  baseMapper.selectById(id);
    }
}
