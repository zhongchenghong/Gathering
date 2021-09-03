package com.museum.service.impl;

import com.museum.domain.PublicSentiment;
import com.museum.dao.PublicSentimentMapper;
import com.museum.service.IPublicSentimentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-舆情 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Service
public class PublicSentimentServiceImpl extends ServiceImpl<PublicSentimentMapper, PublicSentiment> implements IPublicSentimentService {

    @Override
    public  IPage<PublicSentiment> findListByPage(Integer page, Integer pageCount){
        IPage<PublicSentiment> wherePage = new Page<>(page, pageCount);
        PublicSentiment where = new PublicSentiment();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(PublicSentiment publicSentiment){
        return baseMapper.insert(publicSentiment);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(PublicSentiment publicSentiment){
        return baseMapper.updateById(publicSentiment);
    }

    @Override
    public PublicSentiment findById(Long id){
        return  baseMapper.selectById(id);
    }
}
