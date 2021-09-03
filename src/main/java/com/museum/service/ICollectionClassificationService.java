package com.museum.service;

import com.museum.domain.CollectionClassification;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 藏品管理系统（分类统计） 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
public interface ICollectionClassificationService extends IService<CollectionClassification> {

    /**
     * 查询藏品管理系统（分类统计）分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<CollectionClassification>
     */
    IPage<CollectionClassification> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加藏品管理系统（分类统计）
     *
     * @param collectionClassification 藏品管理系统（分类统计）
     * @return int
     */
    int add(CollectionClassification collectionClassification);

    /**
     * 删除藏品管理系统（分类统计）
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改藏品管理系统（分类统计）
     *
     * @param collectionClassification 藏品管理系统（分类统计）
     * @return int
     */
    int updateData(CollectionClassification collectionClassification);

    /**
     * id查询数据
     *
     * @param id id
     * @return CollectionClassification
     */
    CollectionClassification findById(Long id);
}
