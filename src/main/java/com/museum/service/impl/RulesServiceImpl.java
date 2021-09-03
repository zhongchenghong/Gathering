package com.museum.service.impl;

import com.museum.domain.Rules;
import com.museum.dao.RulesMapper;
import com.museum.service.IRulesService;
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
 * @since 2021-07-09
 */
@Service
public class RulesServiceImpl extends ServiceImpl<RulesMapper, Rules> implements IRulesService {

    @Override
    public  IPage<Rules> findListByPage(Integer page, Integer pageCount){
        IPage<Rules> wherePage = new Page<>(page, pageCount);
        Rules where = new Rules();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Rules rules){
        return baseMapper.insert(rules);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Rules rules){
        return baseMapper.updateById(rules);
    }

    @Override
    public Rules findById(Long id){
        return  baseMapper.selectById(id);
    }
}
