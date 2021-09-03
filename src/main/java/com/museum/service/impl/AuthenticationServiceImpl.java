package com.museum.service.impl;

import com.museum.domain.Authentication;
import com.museum.dao.AuthenticationMapper;
import com.museum.service.IAuthenticationService;
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
 * @since 2021-06-08
 */
@Service
public class AuthenticationServiceImpl extends ServiceImpl<AuthenticationMapper, Authentication> implements IAuthenticationService {

    @Override
    public  IPage<Authentication> findListByPage(Integer page, Integer pageCount){
        IPage<Authentication> wherePage = new Page<>(page, pageCount);
        Authentication where = new Authentication();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Authentication authentication){
        return baseMapper.insert(authentication);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Authentication authentication){
        return baseMapper.updateById(authentication);
    }

    @Override
    public Authentication findById(Long id){
        return  baseMapper.selectById(id);
    }
}
