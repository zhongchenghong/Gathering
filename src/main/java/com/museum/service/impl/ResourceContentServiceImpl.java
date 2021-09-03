package com.museum.service.impl;

import com.museum.domain.ResourceContent;
import com.museum.dao.ResourceContentMapper;
import com.museum.service.IResourceContentService;
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
 * @since 2021-06-18
 */
@Service
public class ResourceContentServiceImpl extends ServiceImpl<ResourceContentMapper, ResourceContent> implements IResourceContentService {

    @Override
    public  IPage<ResourceContent> findListByPage(Integer page, Integer pageCount){
        IPage<ResourceContent> wherePage = new Page<>(page, pageCount);
        ResourceContent where = new ResourceContent();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ResourceContent resourceContent){
        return baseMapper.insert(resourceContent);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ResourceContent resourceContent){
        return baseMapper.updateById(resourceContent);
    }

    @Override
    public ResourceContent findById(Long id){
        return  baseMapper.selectById(id);
    }
}
