package com.museum.service.impl;

import com.museum.domain.SysError;
import com.museum.dao.SysErrorMapper;
import com.museum.service.ISysErrorService;
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
public class SysErrorServiceImpl extends ServiceImpl<SysErrorMapper, SysError> implements ISysErrorService {

    @Override
    public  IPage<SysError> findListByPage(Integer page, Integer pageCount){
        IPage<SysError> wherePage = new Page<>(page, pageCount);
        SysError where = new SysError();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(SysError sysError){
        return baseMapper.insert(sysError);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(SysError sysError){
        return baseMapper.updateById(sysError);
    }

    @Override
    public SysError findById(Long id){
        return  baseMapper.selectById(id);
    }
}
