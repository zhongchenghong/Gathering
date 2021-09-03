package com.museum.service;

import com.museum.domain.PublisherAssembly;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 发布者组件 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-10
 */
public interface IPublisherAssemblyService extends IService<PublisherAssembly> {

    /**
     * 查询发布者组件分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<PublisherAssembly>
     */
    IPage<PublisherAssembly> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加发布者组件
     *
     * @param publisherAssembly 发布者组件
     * @return int
     */
    int add(PublisherAssembly publisherAssembly);

    /**
     * 删除发布者组件
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改发布者组件
     *
     * @param publisherAssembly 发布者组件
     * @return int
     */
    int updateData(PublisherAssembly publisherAssembly);

    /**
     * id查询数据
     *
     * @param id id
     * @return PublisherAssembly
     */
    PublisherAssembly findById(Long id);
}
