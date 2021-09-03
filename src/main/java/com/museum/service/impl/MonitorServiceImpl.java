package com.museum.service.impl;

import com.museum.domain.Monitor;
import com.museum.dao.MonitorMapper;
import com.museum.service.IMonitorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 系统监听 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-26
 */
@Service
public class MonitorServiceImpl extends ServiceImpl<MonitorMapper, Monitor> implements IMonitorService {

    @Override
    public  IPage<Monitor> findListByPage(Integer page, Integer pageCount){
        IPage<Monitor> wherePage = new Page<>(page, pageCount);
        Monitor where = new Monitor();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Monitor monitor){
        return baseMapper.insert(monitor);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Monitor monitor){
        return baseMapper.updateById(monitor);
    }

    @Override
    public Monitor findById(Long id){
        return  baseMapper.selectById(id);
    }
}
