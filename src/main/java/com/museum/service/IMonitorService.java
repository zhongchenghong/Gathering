package com.museum.service;

import com.museum.domain.Monitor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 系统监听 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-26
 */
public interface IMonitorService extends IService<Monitor> {

    /**
     * 查询系统监听分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Monitor>
     */
    IPage<Monitor> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加系统监听
     *
     * @param monitor 系统监听
     * @return int
     */
    int add(Monitor monitor);

    /**
     * 删除系统监听
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改系统监听
     *
     * @param monitor 系统监听
     * @return int
     */
    int updateData(Monitor monitor);

    /**
     * id查询数据
     *
     * @param id id
     * @return Monitor
     */
    Monitor findById(Long id);
}
