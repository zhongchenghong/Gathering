package com.museum.service.impl;

import com.museum.domain.CollectionClassification;
import com.museum.dao.CollectionClassificationMapper;
import com.museum.service.ICollectionClassificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 藏品管理系统（分类统计） 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
@Service
public class CollectionClassificationServiceImpl extends ServiceImpl<CollectionClassificationMapper, CollectionClassification> implements ICollectionClassificationService {

    @Override
    public  IPage<CollectionClassification> findListByPage(Integer page, Integer pageCount){
        IPage<CollectionClassification> wherePage = new Page<>(page, pageCount);
        CollectionClassification where = new CollectionClassification();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(CollectionClassification collectionClassification){
        return baseMapper.insert(collectionClassification);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(CollectionClassification collectionClassification){
        return baseMapper.updateById(collectionClassification);
    }

    @Override
    public CollectionClassification findById(Long id){
        return  baseMapper.selectById(id);
    }
}
