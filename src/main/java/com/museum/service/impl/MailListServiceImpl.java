package com.museum.service.impl;

import com.museum.dao.AccountListMapper;
import com.museum.domain.AccountList;
import com.museum.domain.MailList;
import com.museum.dao.MailListMapper;
import com.museum.service.IMailListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-01
 */
@Service
public class MailListServiceImpl extends ServiceImpl<MailListMapper, MailList> implements IMailListService {
    @Resource
    private AccountListMapper accountlistMapper;
    @Override
    public  IPage<MailList> findListByPage(Integer page, Integer pageCount){
        IPage<MailList> wherePage = new Page<>(page, pageCount);
        MailList where = new MailList();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(MailList mailList){
        return baseMapper.insert(mailList);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(MailList mailList){
        return baseMapper.updateById(mailList);
    }

    @Override
    public MailList findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<AccountList> accountList(int id,int uid) {
        return accountlistMapper.accountList(id,uid);
    }
    @Override
    public List<AccountList> accounttotalList(String name,int uid){
        return accountlistMapper.accounttotalList(name,uid);
    }
}
