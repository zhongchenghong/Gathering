package com.museum.service.impl;

import com.museum.domain.FinanceApplyPlan;
import com.museum.dao.FinanceApplyPlanMapper;
import com.museum.service.IFinanceApplyPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 用款计划申请 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 */
@Service
public class FinanceApplyPlanServiceImpl extends ServiceImpl<FinanceApplyPlanMapper, FinanceApplyPlan> implements IFinanceApplyPlanService {

    @Override
    public  IPage<FinanceApplyPlan> findListByPage(Integer page, Integer pageCount){
        IPage<FinanceApplyPlan> wherePage = new Page<>(page, pageCount);
        FinanceApplyPlan where = new FinanceApplyPlan();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(FinanceApplyPlan financeApplyPlan){
        return baseMapper.insert(financeApplyPlan);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(FinanceApplyPlan financeApplyPlan){
        return baseMapper.updateById(financeApplyPlan);
    }

    @Override
    public FinanceApplyPlan findById(Long id){
        return  baseMapper.selectById(id);
    }
}
