package com.museum.service;

import com.museum.domain.Agent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-05
 */
public interface IAgentService extends IService<Agent> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Agent>
     */
    IPage<Agent> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param agent 
     * @return int
     */
    int add(Agent agent);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param agent 
     * @return int
     */
    int updateData(Agent agent);

    /**
     * id查询数据
     *
     * @param id id
     * @return Agent
     */
    Agent findById(Long id);
}
