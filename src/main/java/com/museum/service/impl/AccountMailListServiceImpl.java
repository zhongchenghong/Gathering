package com.museum.service.impl;

import com.museum.domain.AccountMailList;
import com.museum.dao.AccountMailListMapper;
import com.museum.service.IAccountMailListService;
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
 * @since 2021-07-01
 */
@Service
public class AccountMailListServiceImpl extends ServiceImpl<AccountMailListMapper, AccountMailList> implements IAccountMailListService {

    @Override
    public  IPage<AccountMailList> findListByPage(Integer page, Integer pageCount){
        IPage<AccountMailList> wherePage = new Page<>(page, pageCount);
        AccountMailList where = new AccountMailList();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(AccountMailList accountMailList){
        return baseMapper.insert(accountMailList);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(AccountMailList accountMailList){
        return baseMapper.updateById(accountMailList);
    }

    @Override
    public AccountMailList findById(Long id){
        return  baseMapper.selectById(id);
    }
}
