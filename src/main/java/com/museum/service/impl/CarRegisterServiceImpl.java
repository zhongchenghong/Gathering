package com.museum.service.impl;

import com.museum.domain.CarRegister;
import com.museum.dao.CarRegisterMapper;
import com.museum.service.ICarRegisterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 新车登记 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Service
public class CarRegisterServiceImpl extends ServiceImpl<CarRegisterMapper, CarRegister> implements ICarRegisterService {

    @Override
    public  IPage<CarRegister> findListByPage(Integer page, Integer pageCount){
        IPage<CarRegister> wherePage = new Page<>(page, pageCount);
        CarRegister where = new CarRegister();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(CarRegister carRegister){
        return baseMapper.insert(carRegister);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(CarRegister carRegister){
        return baseMapper.updateById(carRegister);
    }

    @Override
    public CarRegister findById(Long id){
        return  baseMapper.selectById(id);
    }
}
