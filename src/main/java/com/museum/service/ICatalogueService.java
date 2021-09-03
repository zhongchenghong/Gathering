package com.museum.service;

import com.museum.domain.Catalogue;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-目录管理 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
public interface ICatalogueService extends IService<Catalogue> {

    /**
     * 查询数据中心-目录管理分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Catalogue>
     */
    IPage<Catalogue> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-目录管理
     *
     * @param catalogue 数据中心-目录管理
     * @return int
     */
    int add(Catalogue catalogue);

    /**
     * 删除数据中心-目录管理
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-目录管理
     *
     * @param catalogue 数据中心-目录管理
     * @return int
     */
    int updateData(Catalogue catalogue);

    /**
     * id查询数据
     *
     * @param id id
     * @return Catalogue
     */
    Catalogue findById(Long id);
}
