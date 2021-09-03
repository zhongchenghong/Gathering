package com.museum.service.impl;

import com.museum.domain.Branchlibrary;
import com.museum.dao.BranchlibraryMapper;
import com.museum.service.IBranchlibraryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 分管馆长跟部门绑定 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-28
 */
@Service
public class BranchlibraryServiceImpl extends ServiceImpl<BranchlibraryMapper, Branchlibrary> implements IBranchlibraryService {

    @Override
    public  IPage<Branchlibrary> findListByPage(Integer page, Integer pageCount){
        IPage<Branchlibrary> wherePage = new Page<>(page, pageCount);
        Branchlibrary where = new Branchlibrary();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Branchlibrary branchlibrary){
        return baseMapper.insert(branchlibrary);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Branchlibrary branchlibrary){
        return baseMapper.updateById(branchlibrary);
    }

    @Override
    public Branchlibrary findById(Long id){
        return  baseMapper.selectById(id);
    }
}
