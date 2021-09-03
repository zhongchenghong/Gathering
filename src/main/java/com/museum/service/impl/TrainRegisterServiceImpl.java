package com.museum.service.impl;

import com.museum.domain.TrainRegister;
import com.museum.dao.TrainRegisterMapper;
import com.museum.service.ITrainRegisterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 锦里培训登记 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Service
public class TrainRegisterServiceImpl extends ServiceImpl<TrainRegisterMapper, TrainRegister> implements ITrainRegisterService {

    @Override
    public  IPage<TrainRegister> findListByPage(Integer page, Integer pageCount){
        IPage<TrainRegister> wherePage = new Page<>(page, pageCount);
        TrainRegister where = new TrainRegister();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(TrainRegister trainRegister){
        return baseMapper.insert(trainRegister);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(TrainRegister trainRegister){
        return baseMapper.updateById(trainRegister);
    }

    @Override
    public TrainRegister findById(Long id){
        return  baseMapper.selectById(id);
    }
}
