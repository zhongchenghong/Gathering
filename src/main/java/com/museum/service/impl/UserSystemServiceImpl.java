package com.museum.service.impl;

import com.museum.domain.UserSystem;
import com.museum.dao.UserSystemMapper;
import com.museum.service.IUserSystemService;
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
 * @since 2021-05-20
 */
@Service
public class UserSystemServiceImpl extends ServiceImpl<UserSystemMapper, UserSystem> implements IUserSystemService {

    @Override
    public  IPage<UserSystem> findListByPage(Integer page, Integer pageCount){
        IPage<UserSystem> wherePage = new Page<>(page, pageCount);
        UserSystem where = new UserSystem();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(UserSystem userSystem){
        return baseMapper.insert(userSystem);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(UserSystem userSystem){
        return baseMapper.updateById(userSystem);
    }

    @Override
    public UserSystem findById(Long id){
        return  baseMapper.selectById(id);
    }
}
