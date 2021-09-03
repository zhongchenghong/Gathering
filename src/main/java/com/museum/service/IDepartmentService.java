package com.museum.service;

import com.museum.domain.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-04
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Department>
     */
    IPage<Department> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param department 
     * @return int
     */
    int add(Department department);

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
     * @param department 
     * @return int
     */
    int updateData(Department department);

    /**
     * id查询数据
     *
     * @param id id
     * @return Department
     */
    Department findById(Long id);
}
