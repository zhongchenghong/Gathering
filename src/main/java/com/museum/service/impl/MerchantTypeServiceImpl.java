package com.museum.service.impl;

import com.museum.domain.MerchantType;
import com.museum.dao.MerchantTypeMapper;
import com.museum.service.IMerchantTypeService;
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
 * @since 2021-08-11
 */
@Service
public class MerchantTypeServiceImpl extends ServiceImpl<MerchantTypeMapper, MerchantType> implements IMerchantTypeService {

    @Override
    public  IPage<MerchantType> findListByPage(Integer page, Integer pageCount){
        IPage<MerchantType> wherePage = new Page<>(page, pageCount);
        MerchantType where = new MerchantType();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(MerchantType merchantType){
        return baseMapper.insert(merchantType);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(MerchantType merchantType){
        return baseMapper.updateById(merchantType);
    }

    @Override
    public MerchantType findById(Long id){
        return  baseMapper.selectById(id);
    }
}
