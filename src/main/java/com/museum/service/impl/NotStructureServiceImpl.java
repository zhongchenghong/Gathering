package com.museum.service.impl;

import com.museum.domain.NotStructure;
import com.museum.dao.NotStructureMapper;
import com.museum.service.INotStructureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-非结构化数据 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Service
public class NotStructureServiceImpl extends ServiceImpl<NotStructureMapper, NotStructure> implements INotStructureService {

    @Override
    public  IPage<NotStructure> findListByPage(Integer page, Integer pageCount){
        IPage<NotStructure> wherePage = new Page<>(page, pageCount);
        NotStructure where = new NotStructure();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(NotStructure notStructure){
        return baseMapper.insert(notStructure);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(NotStructure notStructure){
        return baseMapper.updateById(notStructure);
    }

    @Override
    public NotStructure findById(Long id){
        return  baseMapper.selectById(id);
    }
}
