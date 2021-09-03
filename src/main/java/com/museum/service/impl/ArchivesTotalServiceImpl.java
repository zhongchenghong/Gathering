package com.museum.service.impl;

import com.museum.domain.ArchivesTotal;
import com.museum.dao.ArchivesTotalMapper;
import com.museum.service.IArchivesTotalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 档案统计 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-27
 */
@Service
public class ArchivesTotalServiceImpl extends ServiceImpl<ArchivesTotalMapper, ArchivesTotal> implements IArchivesTotalService {

    @Override
    public  IPage<ArchivesTotal> findListByPage(Integer page, Integer pageCount){
        IPage<ArchivesTotal> wherePage = new Page<>(page, pageCount);
        ArchivesTotal where = new ArchivesTotal();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ArchivesTotal archivesTotal){
        return baseMapper.insert(archivesTotal);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ArchivesTotal archivesTotal){
        return baseMapper.updateById(archivesTotal);
    }

    @Override
    public ArchivesTotal findById(Long id){
        return  baseMapper.selectById(id);
    }
}
