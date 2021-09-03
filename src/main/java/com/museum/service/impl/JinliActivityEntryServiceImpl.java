package com.museum.service.impl;

import com.museum.domain.JinliActivityEntry;
import com.museum.dao.JinliActivityEntryMapper;
import com.museum.service.IJinliActivityEntryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 锦里公司活动录入 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Service
public class JinliActivityEntryServiceImpl extends ServiceImpl<JinliActivityEntryMapper, JinliActivityEntry> implements IJinliActivityEntryService {

    @Override
    public  IPage<JinliActivityEntry> findListByPage(Integer page, Integer pageCount){
        IPage<JinliActivityEntry> wherePage = new Page<>(page, pageCount);
        JinliActivityEntry where = new JinliActivityEntry();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(JinliActivityEntry jinliActivityEntry){
        return baseMapper.insert(jinliActivityEntry);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(JinliActivityEntry jinliActivityEntry){
        return baseMapper.updateById(jinliActivityEntry);
    }

    @Override
    public JinliActivityEntry findById(Long id){
        return  baseMapper.selectById(id);
    }
}
