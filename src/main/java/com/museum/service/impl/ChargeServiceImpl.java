package com.museum.service.impl;

import com.museum.domain.Charge;
import com.museum.dao.ChargeMapper;
import com.museum.service.IChargeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-电力符合数 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Service
public class ChargeServiceImpl extends ServiceImpl<ChargeMapper, Charge> implements IChargeService {

    @Override
    public  IPage<Charge> findListByPage(Integer page, Integer pageCount){
        IPage<Charge> wherePage = new Page<>(page, pageCount);
        Charge where = new Charge();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Charge charge){
        return baseMapper.insert(charge);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Charge charge){
        return baseMapper.updateById(charge);
    }

    @Override
    public Charge findById(Long id){
        return  baseMapper.selectById(id);
    }
}
