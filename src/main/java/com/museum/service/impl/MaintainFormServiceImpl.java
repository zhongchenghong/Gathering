package com.museum.service.impl;

import com.museum.domain.MaintainForm;
import com.museum.dao.MaintainFormMapper;
import com.museum.service.IMaintainFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 软硬件维护维修申请单 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
@Service
public class MaintainFormServiceImpl extends ServiceImpl<MaintainFormMapper, MaintainForm> implements IMaintainFormService {

    @Override
    public  IPage<MaintainForm> findListByPage(Integer page, Integer pageCount){
        IPage<MaintainForm> wherePage = new Page<>(page, pageCount);
        MaintainForm where = new MaintainForm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(MaintainForm maintainForm){
        return baseMapper.insert(maintainForm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(MaintainForm maintainForm){
        return baseMapper.updateById(maintainForm);
    }

    @Override
    public MaintainForm findById(Long id){
        return  baseMapper.selectById(id);
    }
}
