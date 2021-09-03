package com.museum.service.impl;

import com.museum.domain.AdditionProduct;
import com.museum.dao.AdditionProductMapper;
import com.museum.service.IAdditionProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 文创产业部-新增产品 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Service
public class AdditionProductServiceImpl extends ServiceImpl<AdditionProductMapper, AdditionProduct> implements IAdditionProductService {

    @Override
    public  IPage<AdditionProduct> findListByPage(Integer page, Integer pageCount){
        IPage<AdditionProduct> wherePage = new Page<>(page, pageCount);
        AdditionProduct where = new AdditionProduct();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(AdditionProduct additionProduct){
        return baseMapper.insert(additionProduct);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(AdditionProduct additionProduct){
        return baseMapper.updateById(additionProduct);
    }

    @Override
    public AdditionProduct findById(Long id){
        return  baseMapper.selectById(id);
    }
}
