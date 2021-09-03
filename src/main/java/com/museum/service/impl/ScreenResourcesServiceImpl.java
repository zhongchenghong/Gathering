package com.museum.service.impl;

import com.museum.domain.ScreenResources;
import com.museum.dao.ScreenResourcesMapper;
import com.museum.service.IScreenResourcesService;
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
 * @since 2021-06-29
 */
@Service
public class ScreenResourcesServiceImpl extends ServiceImpl<ScreenResourcesMapper, ScreenResources> implements IScreenResourcesService {

    @Override
    public  IPage<ScreenResources> findListByPage(Integer page, Integer pageCount){
        IPage<ScreenResources> wherePage = new Page<>(page, pageCount);
        ScreenResources where = new ScreenResources();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ScreenResources screenResources){
        return baseMapper.insert(screenResources);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ScreenResources screenResources){
        return baseMapper.updateById(screenResources);
    }

    @Override
    public ScreenResources findById(Long id){
        return  baseMapper.selectById(id);
    }
}
