package com.museum.service;

import com.museum.domain.Binding;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-28
 */
public interface IBindingService extends IService<Binding> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Binding>
     */
    IPage<Binding> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param binding 
     * @return int
     */
    int add(Binding binding);

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
     * @param binding 
     * @return int
     */
    int updateData(Binding binding);

    /**
     * id查询数据
     *
     * @param id id
     * @return Binding
     */
    Binding findById(Long id);
}
