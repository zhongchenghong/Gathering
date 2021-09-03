package com.museum.service;

import com.museum.domain.Resources;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-09
 */
public interface IResourcesService extends IService<Resources> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Resources>
     */
    IPage<Resources> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param resources 
     * @return int
     */
    int add(Resources resources);

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
     * @param resources 
     * @return int
     */
    int updateData(Resources resources);

    /**
     * id查询数据
     *
     * @param id id
     * @return Resources
     */
    Resources findById(Long id);
}
