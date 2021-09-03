package com.museum.service;

import com.museum.domain.GroupByMonth;
import com.museum.domain.ProductIncome;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 文化公司产品收入 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
public interface IProductIncomeService extends IService<ProductIncome> {

    /**
     * 查询文化公司产品收入分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ProductIncome>
     */
    IPage<ProductIncome> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加文化公司产品收入
     *
     * @param productIncome 文化公司产品收入
     * @return int
     */
    int add(ProductIncome productIncome);

    /**
     * 删除文化公司产品收入
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改文化公司产品收入
     *
     * @param productIncome 文化公司产品收入
     * @return int
     */
    int updateData(ProductIncome productIncome);

    /**
     * id查询数据
     *
     * @param id id
     * @return ProductIncome
     */
    ProductIncome findById(Long id);

    /**
     * 获取月统计数据
     * @param year
     * @param type
     * @return
     */
    List<GroupByMonth> getmoneyByMonth(String year, String type);
}
