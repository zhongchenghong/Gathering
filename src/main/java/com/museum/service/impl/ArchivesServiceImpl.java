package com.museum.service.impl;

import com.museum.domain.ArchiveBydepartment;
import com.museum.domain.Archives;
import com.museum.dao.ArchivesMapper;
import com.museum.service.IArchivesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-15
 */
@Service
public class ArchivesServiceImpl extends ServiceImpl<ArchivesMapper, Archives> implements IArchivesService {

    @Override
    public  IPage<Archives> findListByPage(Integer page, Integer pageCount){
        IPage<Archives> wherePage = new Page<>(page, pageCount);
        Archives where = new Archives();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Archives archives){
        return baseMapper.insert(archives);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Archives archives){
        return baseMapper.updateById(archives);
    }

    @Override
    public Archives findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<ArchiveBydepartment> selectArchiveBydepartment() {
        return  baseMapper.selectArchiveBydepartment();
    }

    @Override
    public List<ArchiveBydepartment> selectarchivesTypeId(String createTime) {
        return baseMapper.selectarchivesTypeId(createTime);
    }
}
