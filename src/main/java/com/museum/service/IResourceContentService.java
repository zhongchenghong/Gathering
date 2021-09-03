package com.museum.service;

import com.museum.domain.ResourceContent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-18
 */
public interface IResourceContentService extends IService<ResourceContent> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ResourceContent>
     */
    IPage<ResourceContent> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param resourceContent 
     * @return int
     */
    int add(ResourceContent resourceContent);

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
     * @param resourceContent 
     * @return int
     */
    int updateData(ResourceContent resourceContent);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResourceContent
     */
    ResourceContent findById(Long id);
}
