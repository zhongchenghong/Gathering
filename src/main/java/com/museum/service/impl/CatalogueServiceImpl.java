package com.museum.service.impl;

import com.museum.domain.Catalogue;
import com.museum.dao.CatalogueMapper;
import com.museum.service.ICatalogueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-目录管理 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Service
public class CatalogueServiceImpl extends ServiceImpl<CatalogueMapper, Catalogue> implements ICatalogueService {

    @Override
    public  IPage<Catalogue> findListByPage(Integer page, Integer pageCount){
        IPage<Catalogue> wherePage = new Page<>(page, pageCount);
        Catalogue where = new Catalogue();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Catalogue catalogue){
        return baseMapper.insert(catalogue);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Catalogue catalogue){
        return baseMapper.updateById(catalogue);
    }

    @Override
    public Catalogue findById(Long id){
        return  baseMapper.selectById(id);
    }
}
