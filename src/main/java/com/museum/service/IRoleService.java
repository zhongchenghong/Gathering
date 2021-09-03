package com.museum.service;

import com.museum.domain.Role;
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
public interface IRoleService extends IService<Role> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Role>
     */
    IPage<Role> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param role 
     * @return int
     */
    int add(Role role);

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
     * @param role 
     * @return int
     */
    int updateData(Role role);

    /**
     * id查询数据
     *
     * @param id id
     * @return Role
     */
    Role findById(Long id);
}
