package com.museum.service.impl;

import com.museum.domain.FinanceApplyPlanProcess;
import com.museum.dao.FinanceApplyPlanProcessMapper;
import com.museum.service.IFinanceApplyPlanProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 财务用款计划申请流程 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
@Service
public class FinanceApplyPlanProcessServiceImpl extends ServiceImpl<FinanceApplyPlanProcessMapper, FinanceApplyPlanProcess> implements IFinanceApplyPlanProcessService {

    @Override
    public  IPage<FinanceApplyPlanProcess> findListByPage(Integer page, Integer pageCount){
        IPage<FinanceApplyPlanProcess> wherePage = new Page<>(page, pageCount);
        FinanceApplyPlanProcess where = new FinanceApplyPlanProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(FinanceApplyPlanProcess financeApplyPlanProcess){
        return baseMapper.insert(financeApplyPlanProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(FinanceApplyPlanProcess financeApplyPlanProcess){
        return baseMapper.updateById(financeApplyPlanProcess);
    }

    @Override
    public FinanceApplyPlanProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
