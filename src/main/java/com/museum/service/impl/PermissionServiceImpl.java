package com.museum.service.impl;

import com.museum.domain.Permission;
import com.museum.dao.PermissionMapper;
import com.museum.service.IPermissionService;
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
 * @since 2021-06-07
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Override
    public  IPage<Permission> findListByPage(Integer page, Integer pageCount){
        IPage<Permission> wherePage = new Page<>(page, pageCount);
        Permission where = new Permission();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Permission permission){
        return baseMapper.insert(permission);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Permission permission){
        return baseMapper.updateById(permission);
    }

    @Override
    public Permission findById(Long id){
        return  baseMapper.selectById(id);
    }
}
