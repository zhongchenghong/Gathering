package com.museum.service.impl;

import com.museum.domain.Screen;
import com.museum.dao.ScreenMapper;
import com.museum.service.IScreenService;
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
public class ScreenServiceImpl extends ServiceImpl<ScreenMapper, Screen> implements IScreenService {

    @Override
    public  IPage<Screen> findListByPage(Integer page, Integer pageCount){
        IPage<Screen> wherePage = new Page<>(page, pageCount);
        Screen where = new Screen();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Screen screen){
        return baseMapper.insert(screen);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Screen screen){
        return baseMapper.updateById(screen);
    }

    @Override
    public Screen findById(Long id){
        return  baseMapper.selectById(id);
    }
}
