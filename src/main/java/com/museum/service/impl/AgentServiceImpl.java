package com.museum.service.impl;

import com.museum.domain.Agent;
import com.museum.dao.AgentMapper;
import com.museum.service.IAgentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-05
 */
@Service
public class AgentServiceImpl extends ServiceImpl<AgentMapper, Agent> implements IAgentService {

    @Override
    public  IPage<Agent> findListByPage(Integer page, Integer pageCount){
        IPage<Agent> wherePage = new Page<>(page, pageCount);
        Agent where = new Agent();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Agent agent){
        return baseMapper.insert(agent);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Agent agent){
        return baseMapper.updateById(agent);
    }

    @Override
    public Agent findById(Long id){
        return  baseMapper.selectById(id);
    }
}
