package com.museum.service;

import com.museum.domain.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-07
 */
public interface IPermissionService extends IService<Permission> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Permission>
     */
    IPage<Permission> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param permission 
     * @return int
     */
    int add(Permission permission);

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
     * @param permission 
     * @return int
     */
    int updateData(Permission permission);

    /**
     * id查询数据
     *
     * @param id id
     * @return Permission
     */
    Permission findById(Long id);
}
