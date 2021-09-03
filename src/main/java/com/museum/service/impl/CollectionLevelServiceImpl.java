package com.museum.service.impl;

import com.museum.domain.CollectionLevel;
import com.museum.dao.CollectionLevelMapper;
import com.museum.service.ICollectionLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 藏品级别统计 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
@Service
public class CollectionLevelServiceImpl extends ServiceImpl<CollectionLevelMapper, CollectionLevel> implements ICollectionLevelService {

    @Override
    public  IPage<CollectionLevel> findListByPage(Integer page, Integer pageCount){
        IPage<CollectionLevel> wherePage = new Page<>(page, pageCount);
        CollectionLevel where = new CollectionLevel();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(CollectionLevel collectionLevel){
        return baseMapper.insert(collectionLevel);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(CollectionLevel collectionLevel){
        return baseMapper.updateById(collectionLevel);
    }

    @Override
    public CollectionLevel findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public CollectionLevel getsum() {
        return baseMapper.getSum();
    }
}
