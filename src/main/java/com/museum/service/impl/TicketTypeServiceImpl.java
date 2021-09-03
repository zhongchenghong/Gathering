package com.museum.service.impl;

import com.museum.domain.TicketType;
import com.museum.dao.TicketTypeMapper;
import com.museum.service.ITicketTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 财务票价类型 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 */
@Service
public class TicketTypeServiceImpl extends ServiceImpl<TicketTypeMapper, TicketType> implements ITicketTypeService {

    @Override
    public  IPage<TicketType> findListByPage(Integer page, Integer pageCount){
        IPage<TicketType> wherePage = new Page<>(page, pageCount);
        TicketType where = new TicketType();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(TicketType ticketType){
        return baseMapper.insert(ticketType);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(TicketType ticketType){
        return baseMapper.updateById(ticketType);
    }

    @Override
    public TicketType findById(Long id){
        return  baseMapper.selectById(id);
    }
}
