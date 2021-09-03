package com.museum.service.impl;

import com.museum.domain.Topic;
import com.museum.dao.TopicMapper;
import com.museum.service.ITopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-学术课题数据 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements ITopicService {

    @Override
    public  IPage<Topic> findListByPage(Integer page, Integer pageCount){
        IPage<Topic> wherePage = new Page<>(page, pageCount);
        Topic where = new Topic();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Topic topic){
        return baseMapper.insert(topic);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Topic topic){
        return baseMapper.updateById(topic);
    }

    @Override
    public Topic findById(Long id){
        return  baseMapper.selectById(id);
    }
}
