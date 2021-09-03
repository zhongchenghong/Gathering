package com.museum.service.impl;

import com.museum.domain.Architecture;
import com.museum.dao.ArchitectureMapper;
import com.museum.service.IArchitectureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-古建数据 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Service
public class ArchitectureServiceImpl extends ServiceImpl<ArchitectureMapper, Architecture> implements IArchitectureService {

    @Override
    public  IPage<Architecture> findListByPage(Integer page, Integer pageCount){
        IPage<Architecture> wherePage = new Page<>(page, pageCount);
        Architecture where = new Architecture();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Architecture architecture){
        return baseMapper.insert(architecture);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Architecture architecture){
        return baseMapper.updateById(architecture);
    }

    @Override
    public Architecture findById(Long id){
        return  baseMapper.selectById(id);
    }
}
