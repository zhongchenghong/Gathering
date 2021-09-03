package com.museum.service;

import com.museum.domain.CollectionLevel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 藏品级别统计 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
public interface ICollectionLevelService extends IService<CollectionLevel> {

    /**
     * 查询藏品级别统计分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<CollectionLevel>
     */
    IPage<CollectionLevel> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加藏品级别统计
     *
     * @param collectionLevel 藏品级别统计
     * @return int
     */
    int add(CollectionLevel collectionLevel);

    /**
     * 删除藏品级别统计
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改藏品级别统计
     *
     * @param collectionLevel 藏品级别统计
     * @return int
     */
    int updateData(CollectionLevel collectionLevel);

    /**
     * id查询数据
     *
     * @param id id
     * @return CollectionLevel
     */
    CollectionLevel findById(Long id);

    /**
     * 藏品统计
     */

    CollectionLevel getsum();
}
