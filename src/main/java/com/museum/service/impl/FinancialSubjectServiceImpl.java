package com.museum.service.impl;

import com.museum.domain.FinancialSubject;
import com.museum.dao.FinancialSubjectMapper;
import com.museum.service.IFinancialSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 财务部科目 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 */
@Service
public class FinancialSubjectServiceImpl extends ServiceImpl<FinancialSubjectMapper, FinancialSubject> implements IFinancialSubjectService {

    @Override
    public  IPage<FinancialSubject> findListByPage(Integer page, Integer pageCount){
        IPage<FinancialSubject> wherePage = new Page<>(page, pageCount);
        FinancialSubject where = new FinancialSubject();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(FinancialSubject financialSubject){
        return baseMapper.insert(financialSubject);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(FinancialSubject financialSubject){
        return baseMapper.updateById(financialSubject);
    }

    @Override
    public FinancialSubject findById(Long id){
        return  baseMapper.selectById(id);
    }
}
