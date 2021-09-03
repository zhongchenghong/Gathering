package com.museum.service.impl;

import com.museum.domain.FinanceContent;
import com.museum.dao.FinanceContentMapper;
import com.museum.service.IFinanceContentService;
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
 * @since 2021-08-13
 */
@Service
public class FinanceContentServiceImpl extends ServiceImpl<FinanceContentMapper, FinanceContent> implements IFinanceContentService {

    @Override
    public  IPage<FinanceContent> findListByPage(Integer page, Integer pageCount){
        IPage<FinanceContent> wherePage = new Page<>(page, pageCount);
        FinanceContent where = new FinanceContent();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(FinanceContent financeContent){
        return baseMapper.insert(financeContent);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(FinanceContent financeContent){
        return baseMapper.updateById(financeContent);
    }

    @Override
    public FinanceContent findById(Long id){
        return  baseMapper.selectById(id);
    }
}
