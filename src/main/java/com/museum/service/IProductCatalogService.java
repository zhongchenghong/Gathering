package com.museum.service;

import com.museum.domain.ProductCatalog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 文化公司驾驶舱-产品目录 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
public interface IProductCatalogService extends IService<ProductCatalog> {

    /**
     * 查询文化公司驾驶舱-产品目录分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ProductCatalog>
     */
    IPage<ProductCatalog> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加文化公司驾驶舱-产品目录
     *
     * @param productCatalog 文化公司驾驶舱-产品目录
     * @return int
     */
    int add(ProductCatalog productCatalog);

    /**
     * 删除文化公司驾驶舱-产品目录
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改文化公司驾驶舱-产品目录
     *
     * @param productCatalog 文化公司驾驶舱-产品目录
     * @return int
     */
    int updateData(ProductCatalog productCatalog);

    /**
     * id查询数据
     *
     * @param id id
     * @return ProductCatalog
     */
    ProductCatalog findById(Long id);
}
