package com.museum.service.impl;

import com.museum.domain.ParkingProcess;
import com.museum.dao.ParkingProcessMapper;
import com.museum.service.IParkingProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 临时停车申请流程 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
@Service
public class ParkingProcessServiceImpl extends ServiceImpl<ParkingProcessMapper, ParkingProcess> implements IParkingProcessService {

    @Override
    public  IPage<ParkingProcess> findListByPage(Integer page, Integer pageCount){
        IPage<ParkingProcess> wherePage = new Page<>(page, pageCount);
        ParkingProcess where = new ParkingProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ParkingProcess parkingProcess){
        return baseMapper.insert(parkingProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ParkingProcess parkingProcess){
        return baseMapper.updateById(parkingProcess);
    }

    @Override
    public ParkingProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
