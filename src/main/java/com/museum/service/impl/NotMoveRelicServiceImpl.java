package com.museum.service.impl;

import com.museum.domain.NotMoveRelic;
import com.museum.dao.NotMoveRelicMapper;
import com.museum.service.INotMoveRelicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-不可移动文物 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Service
public class NotMoveRelicServiceImpl extends ServiceImpl<NotMoveRelicMapper, NotMoveRelic> implements INotMoveRelicService {

    @Override
    public  IPage<NotMoveRelic> findListByPage(Integer page, Integer pageCount){
        IPage<NotMoveRelic> wherePage = new Page<>(page, pageCount);
        NotMoveRelic where = new NotMoveRelic();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(NotMoveRelic notMoveRelic){
        return baseMapper.insert(notMoveRelic);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(NotMoveRelic notMoveRelic){
        return baseMapper.updateById(notMoveRelic);
    }

    @Override
    public NotMoveRelic findById(Long id){
        return  baseMapper.selectById(id);
    }
}
