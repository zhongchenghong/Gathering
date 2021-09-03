package com.museum.service.impl;

import com.museum.domain.Resources;
import com.museum.dao.ResourcesMapper;
import com.museum.service.IResourcesService;
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
 * @since 2021-06-09
 */
@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesMapper, Resources> implements IResourcesService {

    @Override
    public  IPage<Resources> findListByPage(Integer page, Integer pageCount){
        IPage<Resources> wherePage = new Page<>(page, pageCount);
        Resources where = new Resources();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Resources resources){
        return baseMapper.insert(resources);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Resources resources){
        return baseMapper.updateById(resources);
    }

    @Override
    public Resources findById(Long id){
        return  baseMapper.selectById(id);
    }
}
