package com.museum.service;

import com.museum.domain.AdditionProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 文创产业部-新增产品 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
public interface IAdditionProductService extends IService<AdditionProduct> {

    /**
     * 查询文创产业部-新增产品分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<AdditionProduct>
     */
    IPage<AdditionProduct> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加文创产业部-新增产品
     *
     * @param additionProduct 文创产业部-新增产品
     * @return int
     */
    int add(AdditionProduct additionProduct);

    /**
     * 删除文创产业部-新增产品
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改文创产业部-新增产品
     *
     * @param additionProduct 文创产业部-新增产品
     * @return int
     */
    int updateData(AdditionProduct additionProduct);

    /**
     * id查询数据
     *
     * @param id id
     * @return AdditionProduct
     */
    AdditionProduct findById(Long id);
}
