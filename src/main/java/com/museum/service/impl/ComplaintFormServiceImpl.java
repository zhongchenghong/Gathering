package com.museum.service.impl;

import com.museum.domain.ComplaintForm;
import com.museum.dao.ComplaintFormMapper;
import com.museum.service.IComplaintFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 投诉处理表单 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-21
 */
@Service
public class ComplaintFormServiceImpl extends ServiceImpl<ComplaintFormMapper, ComplaintForm> implements IComplaintFormService {

    @Override
    public  IPage<ComplaintForm> findListByPage(Integer page, Integer pageCount){
        IPage<ComplaintForm> wherePage = new Page<>(page, pageCount);
        ComplaintForm where = new ComplaintForm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ComplaintForm complaintForm){
        return baseMapper.insert(complaintForm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ComplaintForm complaintForm){
        return baseMapper.updateById(complaintForm);
    }

    @Override
    public ComplaintForm findById(Long id){
        return  baseMapper.selectById(id);
    }
}
