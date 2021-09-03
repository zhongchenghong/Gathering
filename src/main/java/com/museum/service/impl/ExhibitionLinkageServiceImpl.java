package com.museum.service.impl;

import com.museum.domain.ExhibitionLinkage;
import com.museum.dao.ExhibitionLinkageMapper;
import com.museum.service.IExhibitionLinkageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 陈列展览三级联动 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Service
public class ExhibitionLinkageServiceImpl extends ServiceImpl<ExhibitionLinkageMapper, ExhibitionLinkage> implements IExhibitionLinkageService {

    @Override
    public  IPage<ExhibitionLinkage> findListByPage(Integer page, Integer pageCount){
        IPage<ExhibitionLinkage> wherePage = new Page<>(page, pageCount);
        ExhibitionLinkage where = new ExhibitionLinkage();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ExhibitionLinkage exhibitionLinkage){
        return baseMapper.insert(exhibitionLinkage);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ExhibitionLinkage exhibitionLinkage){
        return baseMapper.updateById(exhibitionLinkage);
    }

    @Override
    public ExhibitionLinkage findById(Long id){
        return  baseMapper.selectById(id);
    }
}
