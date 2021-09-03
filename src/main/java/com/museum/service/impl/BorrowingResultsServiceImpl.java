package com.museum.service.impl;

import com.museum.domain.BorrowingResults;
import com.museum.dao.BorrowingResultsMapper;
import com.museum.service.IBorrowingResultsService;
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
 * @since 2021-07-30
 */
@Service
public class BorrowingResultsServiceImpl extends ServiceImpl<BorrowingResultsMapper, BorrowingResults> implements IBorrowingResultsService {

    @Override
    public  IPage<BorrowingResults> findListByPage(Integer page, Integer pageCount){
        IPage<BorrowingResults> wherePage = new Page<>(page, pageCount);
        BorrowingResults where = new BorrowingResults();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(BorrowingResults borrowingResults){
        return baseMapper.insert(borrowingResults);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(BorrowingResults borrowingResults){
        return baseMapper.updateById(borrowingResults);
    }

    @Override
    public BorrowingResults findById(Long id){
        return  baseMapper.selectById(id);
    }
}
