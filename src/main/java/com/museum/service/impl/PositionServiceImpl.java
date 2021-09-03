package com.museum.service.impl;

import com.museum.domain.Position;
import com.museum.dao.PositionMapper;
import com.museum.service.IPositionService;
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
 * @since 2021-06-08
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

    @Override
    public  IPage<Position> findListByPage(Integer page, Integer pageCount){
        IPage<Position> wherePage = new Page<>(page, pageCount);
        Position where = new Position();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Position position){
        return baseMapper.insert(position);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Position position){
        return baseMapper.updateById(position);
    }

    @Override
    public Position findById(Long id){
        return  baseMapper.selectById(id);
    }
}
