package com.museum.service.impl;

import com.museum.domain.CarForm;
import com.museum.dao.CarFormMapper;
import com.museum.service.ICarFormService;
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
 * @since 2021-07-21
 */
@Service
public class CarFormServiceImpl extends ServiceImpl<CarFormMapper, CarForm> implements ICarFormService {

    @Override
    public  IPage<CarForm> findListByPage(Integer page, Integer pageCount){
        IPage<CarForm> wherePage = new Page<>(page, pageCount);
        CarForm where = new CarForm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(CarForm carForm){
        return baseMapper.insert(carForm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(CarForm carForm){
        return baseMapper.updateById(carForm);
    }

    @Override
    public CarForm findById(Long id){
        return  baseMapper.selectById(id);
    }
}
