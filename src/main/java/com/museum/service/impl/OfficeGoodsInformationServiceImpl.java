package com.museum.service.impl;

import com.museum.domain.OfficeGoodsInformation;
import com.museum.dao.OfficeGoodsInformationMapper;
import com.museum.service.IOfficeGoodsInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 办公室录入物品名称 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-19
 */
@Service
public class OfficeGoodsInformationServiceImpl extends ServiceImpl<OfficeGoodsInformationMapper, OfficeGoodsInformation> implements IOfficeGoodsInformationService {

    @Override
    public  IPage<OfficeGoodsInformation> findListByPage(Integer page, Integer pageCount){
        IPage<OfficeGoodsInformation> wherePage = new Page<>(page, pageCount);
        OfficeGoodsInformation where = new OfficeGoodsInformation();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(OfficeGoodsInformation officeGoodsInformation){
        return baseMapper.insert(officeGoodsInformation);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(OfficeGoodsInformation officeGoodsInformation){
        return baseMapper.updateById(officeGoodsInformation);
    }

    @Override
    public OfficeGoodsInformation findById(Long id){
        return  baseMapper.selectById(id);
    }
}
