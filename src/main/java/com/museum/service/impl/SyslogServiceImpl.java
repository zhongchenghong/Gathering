package com.museum.service.impl;

import com.museum.domain.Syslog;
import com.museum.dao.SyslogMapper;
import com.museum.service.ISyslogService;
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
 * @since 2021-06-03
 */
@Service
public class SyslogServiceImpl extends ServiceImpl<SyslogMapper, Syslog> implements ISyslogService {

    @Override
    public  IPage<Syslog> findListByPage(Integer page, Integer pageCount){
        IPage<Syslog> wherePage = new Page<>(page, pageCount);
        Syslog where = new Syslog();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Syslog syslog){
        return baseMapper.insert(syslog);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Syslog syslog){
        return baseMapper.updateById(syslog);
    }

    @Override
    public Syslog findById(Long id){
        return  baseMapper.selectById(id);
    }
}
