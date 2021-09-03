package com.museum.service.impl;

import com.museum.domain.ScreenContent;
import com.museum.dao.ScreenContentMapper;
import com.museum.service.IScreenContentService;
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
public class ScreenContentServiceImpl extends ServiceImpl<ScreenContentMapper, ScreenContent> implements IScreenContentService {

    @Override
    public  IPage<ScreenContent> findListByPage(Integer page, Integer pageCount){
        IPage<ScreenContent> wherePage = new Page<>(page, pageCount);
        ScreenContent where = new ScreenContent();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ScreenContent screenContent){
        return baseMapper.insert(screenContent);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ScreenContent screenContent){
        return baseMapper.updateById(screenContent);
    }

    @Override
    public ScreenContent findById(Long id){
        return  baseMapper.selectById(id);
    }
}
