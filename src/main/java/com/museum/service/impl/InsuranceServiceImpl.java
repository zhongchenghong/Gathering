package com.museum.service.impl;

import com.museum.domain.Insurance;
import com.museum.dao.InsuranceMapper;
import com.museum.service.IInsuranceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 办公室车辆保险 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Service
public class InsuranceServiceImpl extends ServiceImpl<InsuranceMapper, Insurance> implements IInsuranceService {

    @Override
    public  IPage<Insurance> findListByPage(Integer page, Integer pageCount){
        IPage<Insurance> wherePage = new Page<>(page, pageCount);
        Insurance where = new Insurance();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Insurance insurance){
        return baseMapper.insert(insurance);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Insurance insurance){
        return baseMapper.updateById(insurance);
    }

    @Override
    public Insurance findById(Long id){
        return  baseMapper.selectById(id);
    }
}
