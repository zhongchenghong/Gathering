package com.museum.service.impl;

import com.museum.domain.ParkingForm;
import com.museum.dao.ParkingFormMapper;
import com.museum.service.IParkingFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 临时停车表单 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
@Service
public class ParkingFormServiceImpl extends ServiceImpl<ParkingFormMapper, ParkingForm> implements IParkingFormService {

    @Override
    public  IPage<ParkingForm> findListByPage(Integer page, Integer pageCount){
        IPage<ParkingForm> wherePage = new Page<>(page, pageCount);
        ParkingForm where = new ParkingForm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ParkingForm parkingForm){
        return baseMapper.insert(parkingForm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ParkingForm parkingForm){
        return baseMapper.updateById(parkingForm);
    }

    @Override
    public ParkingForm findById(Long id){
        return  baseMapper.selectById(id);
    }
}
