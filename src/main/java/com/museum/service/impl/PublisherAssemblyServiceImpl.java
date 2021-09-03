package com.museum.service.impl;

import com.museum.domain.PublisherAssembly;
import com.museum.dao.PublisherAssemblyMapper;
import com.museum.service.IPublisherAssemblyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 发布者组件 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-10
 */
@Service
public class PublisherAssemblyServiceImpl extends ServiceImpl<PublisherAssemblyMapper, PublisherAssembly> implements IPublisherAssemblyService {

    @Override
    public  IPage<PublisherAssembly> findListByPage(Integer page, Integer pageCount){
        IPage<PublisherAssembly> wherePage = new Page<>(page, pageCount);
        PublisherAssembly where = new PublisherAssembly();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(PublisherAssembly publisherAssembly){
        return baseMapper.insert(publisherAssembly);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(PublisherAssembly publisherAssembly){
        return baseMapper.updateById(publisherAssembly);
    }

    @Override
    public PublisherAssembly findById(Long id){
        return  baseMapper.selectById(id);
    }
}
