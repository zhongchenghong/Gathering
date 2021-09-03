package com.museum.service.impl;

import com.museum.domain.ProcessForm;
import com.museum.dao.ProcessFormMapper;
import com.museum.service.IProcessFormService;
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
 * @since 2021-07-28
 */
@Service
public class ProcessFormServiceImpl extends ServiceImpl<ProcessFormMapper, ProcessForm> implements IProcessFormService {

    @Override
    public  IPage<ProcessForm> findListByPage(Integer page, Integer pageCount){
        IPage<ProcessForm> wherePage = new Page<>(page, pageCount);
        ProcessForm where = new ProcessForm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ProcessForm processForm){
        return baseMapper.insert(processForm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ProcessForm processForm){
        return baseMapper.updateById(processForm);
    }

    @Override
    public ProcessForm findById(Long id){
        return  baseMapper.selectById(id);
    }
}
