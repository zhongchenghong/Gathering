package com.museum.service;

import com.museum.domain.Reception;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-21
 */
public interface IReceptionService extends IService<Reception> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Reception>
     */
    IPage<Reception> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param reception 
     * @return int
     */
    int add(Reception reception);

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
     * @param reception 
     * @return int
     */
    int updateData(Reception reception);

    /**
     * id查询数据
     *
     * @param id id
     * @return Reception
     */
    Reception findById(Long id);
}
