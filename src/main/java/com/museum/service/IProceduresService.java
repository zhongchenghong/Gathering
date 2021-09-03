package com.museum.service;

import com.museum.domain.Procedures;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-20
 */
public interface IProceduresService extends IService<Procedures> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Procedures>
     */
    IPage<Procedures> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param procedures 
     * @return int
     */
    int add(Procedures procedures);

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
     * @param procedures 
     * @return int
     */
    int updateData(Procedures procedures);

    /**
     * id查询数据
     *
     * @param id id
     * @return Procedures
     */
    Procedures findById(Long id);
}
