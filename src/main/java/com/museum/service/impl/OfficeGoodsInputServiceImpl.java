package com.museum.service.impl;

import com.museum.domain.OfficeGoodsInput;
import com.museum.dao.OfficeGoodsInputMapper;
import com.museum.service.IOfficeGoodsInputService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 办公室物品录入 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-19
 */
@Service
public class OfficeGoodsInputServiceImpl extends ServiceImpl<OfficeGoodsInputMapper, OfficeGoodsInput> implements IOfficeGoodsInputService {

    @Override
    public  IPage<OfficeGoodsInput> findListByPage(Integer page, Integer pageCount){
        IPage<OfficeGoodsInput> wherePage = new Page<>(page, pageCount);
        OfficeGoodsInput where = new OfficeGoodsInput();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(OfficeGoodsInput officeGoodsInput){
        return baseMapper.insert(officeGoodsInput);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(OfficeGoodsInput officeGoodsInput){
        return baseMapper.updateById(officeGoodsInput);
    }

    @Override
    public OfficeGoodsInput findById(Long id){
        return  baseMapper.selectById(id);
    }
}
