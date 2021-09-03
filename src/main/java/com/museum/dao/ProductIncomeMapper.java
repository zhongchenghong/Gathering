package com.museum.dao;

import com.museum.domain.GroupByMonth;
import com.museum.domain.ProductIncome;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 文化公司产品收入 Mapper 接口
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
public interface ProductIncomeMapper extends BaseMapper<ProductIncome> {
    @Select("select  sum(money) as price,substring(createtimes, 6, 2) as month from \n" +
            "product_income  where substring(createtimes, 1, 4)=#{year} and product_income.type=#{type} \n" +
            "GROUP BY  substring(product_income.createtimes, 6, 2)")
    List<GroupByMonth> getmoneyByMonth(String year,String type);
}
