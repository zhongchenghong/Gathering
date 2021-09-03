package com.museum.service.impl;

import com.museum.domain.PointsMessage;
import com.museum.dao.PointsMessageMapper;
import com.museum.service.IPointsMessageService;
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
 * @since 2021-06-24
 */
@Service
public class PointsMessageServiceImpl extends ServiceImpl<PointsMessageMapper, PointsMessage> implements IPointsMessageService {

    @Override
    public  IPage<PointsMessage> findListByPage(Integer page, Integer pageCount){
        IPage<PointsMessage> wherePage = new Page<>(page, pageCount);
        PointsMessage where = new PointsMessage();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(PointsMessage pointsMessage){
        return baseMapper.insert(pointsMessage);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(PointsMessage pointsMessage){
        return baseMapper.updateById(pointsMessage);
    }

    @Override
    public PointsMessage findById(Long id){
        return  baseMapper.selectById(id);
    }
}
