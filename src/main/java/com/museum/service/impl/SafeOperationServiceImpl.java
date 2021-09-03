package com.museum.service.impl;

import com.museum.domain.SafeOperation;
import com.museum.dao.SafeOperationMapper;
import com.museum.service.ISafeOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 泰合信息安全运营中心系统 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-27
 */
@Service
public class SafeOperationServiceImpl extends ServiceImpl<SafeOperationMapper, SafeOperation> implements ISafeOperationService {

    @Override
    public  IPage<SafeOperation> findListByPage(Integer page, Integer pageCount){
        IPage<SafeOperation> wherePage = new Page<>(page, pageCount);
        SafeOperation where = new SafeOperation();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(SafeOperation safeOperation){
        return baseMapper.insert(safeOperation);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(SafeOperation safeOperation){
        return baseMapper.updateById(safeOperation);
    }

    @Override
    public SafeOperation findById(Long id){
        return  baseMapper.selectById(id);
    }
}
