package com.museum.service.impl;

import com.museum.domain.Department;
import com.museum.dao.DepartmentMapper;
import com.museum.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-06-04
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Override
    public  IPage<Department> findListByPage(Integer page, Integer pageCount){
        IPage<Department> wherePage = new Page<>(page, pageCount);
        Department where = new Department();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Department department){
        return baseMapper.insert(department);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Department department){
        return baseMapper.updateById(department);
    }

    @Override
    public Department findById(Long id){
        return  baseMapper.selectById(id);
    }
}
