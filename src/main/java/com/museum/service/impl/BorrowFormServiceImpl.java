package com.museum.service.impl;

import com.museum.domain.BorrowForm;
import com.museum.dao.BorrowFormMapper;
import com.museum.service.IBorrowFormService;
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
 * @since 2021-07-26
 */
@Service
public class BorrowFormServiceImpl extends ServiceImpl<BorrowFormMapper, BorrowForm> implements IBorrowFormService {

    @Override
    public  IPage<BorrowForm> findListByPage(Integer page, Integer pageCount){
        IPage<BorrowForm> wherePage = new Page<>(page, pageCount);
        BorrowForm where = new BorrowForm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BorrowForm borrowForm){
        return baseMapper.insert(borrowForm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BorrowForm borrowForm){
        return baseMapper.updateById(borrowForm);
    }

    @Override
    public BorrowForm findById(Long id){
        return  baseMapper.selectById(id);
    }
}
