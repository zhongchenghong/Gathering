package com.museum.service.impl;

import com.museum.domain.ApplicationSubject;
import com.museum.dao.ApplicationSubjectMapper;
import com.museum.service.IApplicationSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 财务部各个科目 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
@Service
public class ApplicationSubjectServiceImpl extends ServiceImpl<ApplicationSubjectMapper, ApplicationSubject> implements IApplicationSubjectService {

    @Override
    public  IPage<ApplicationSubject> findListByPage(Integer page, Integer pageCount){
        IPage<ApplicationSubject> wherePage = new Page<>(page, pageCount);
        ApplicationSubject where = new ApplicationSubject();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ApplicationSubject applicationSubject){
        return baseMapper.insert(applicationSubject);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ApplicationSubject applicationSubject){
        return baseMapper.updateById(applicationSubject);
    }

    @Override
    public ApplicationSubject findById(Long id){
        return  baseMapper.selectById(id);
    }
}
