package com.museum.service;

import com.museum.domain.Jlleader;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 锦里公司领导组件 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
public interface IJlleaderService extends IService<Jlleader> {

    /**
     * 查询锦里公司领导组件分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Jlleader>
     */
    IPage<Jlleader> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加锦里公司领导组件
     *
     * @param jlleader 锦里公司领导组件
     * @return int
     */
    int add(Jlleader jlleader);

    /**
     * 删除锦里公司领导组件
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改锦里公司领导组件
     *
     * @param jlleader 锦里公司领导组件
     * @return int
     */
    int updateData(Jlleader jlleader);

    /**
     * id查询数据
     *
     * @param id id
     * @return Jlleader
     */
    Jlleader findById(Long id);
}
