package com.museum.service.impl;

import com.museum.domain.BorrowProcess;
import com.museum.dao.BorrowProcessMapper;
import com.museum.service.IBorrowProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 档案借阅流程 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-28
 */
@Service
public class BorrowProcessServiceImpl extends ServiceImpl<BorrowProcessMapper, BorrowProcess> implements IBorrowProcessService {

    @Override
    public  IPage<BorrowProcess> findListByPage(Integer page, Integer pageCount){
        IPage<BorrowProcess> wherePage = new Page<>(page, pageCount);
        BorrowProcess where = new BorrowProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BorrowProcess borrowProcess){
        return baseMapper.insert(borrowProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BorrowProcess borrowProcess){
        return baseMapper.updateById(borrowProcess);
    }

    @Override
    public BorrowProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
