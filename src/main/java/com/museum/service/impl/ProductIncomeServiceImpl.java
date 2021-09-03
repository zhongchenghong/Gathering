package com.museum.service.impl;

import com.museum.domain.GroupByMonth;
import com.museum.domain.ProductIncome;
import com.museum.dao.ProductIncomeMapper;
import com.museum.service.IProductIncomeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * <p>
 * 文化公司产品收入 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Service
public class ProductIncomeServiceImpl extends ServiceImpl<ProductIncomeMapper, ProductIncome> implements IProductIncomeService {

    @Override
    public  IPage<ProductIncome> findListByPage(Integer page, Integer pageCount){
        IPage<ProductIncome> wherePage = new Page<>(page, pageCount);
        ProductIncome where = new ProductIncome();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ProductIncome productIncome){
        return baseMapper.insert(productIncome);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ProductIncome productIncome){
        return baseMapper.updateById(productIncome);
    }

    @Override
    public ProductIncome findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<GroupByMonth> getmoneyByMonth(String year, String type) {
        return baseMapper.getmoneyByMonth(year,type);
    }
}
