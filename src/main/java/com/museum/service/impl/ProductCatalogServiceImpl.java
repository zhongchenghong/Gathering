package com.museum.service.impl;

import com.museum.domain.ProductCatalog;
import com.museum.dao.ProductCatalogMapper;
import com.museum.service.IProductCatalogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 文化公司驾驶舱-产品目录 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Service
public class ProductCatalogServiceImpl extends ServiceImpl<ProductCatalogMapper, ProductCatalog> implements IProductCatalogService {

    @Override
    public  IPage<ProductCatalog> findListByPage(Integer page, Integer pageCount){
        IPage<ProductCatalog> wherePage = new Page<>(page, pageCount);
        ProductCatalog where = new ProductCatalog();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ProductCatalog productCatalog){
        return baseMapper.insert(productCatalog);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ProductCatalog productCatalog){
        return baseMapper.updateById(productCatalog);
    }

    @Override
    public ProductCatalog findById(Long id){
        return  baseMapper.selectById(id);
    }
}
