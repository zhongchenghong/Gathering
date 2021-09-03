package com.museum.service.impl;

import com.museum.domain.CulturalAlpplyForm;
import com.museum.dao.CulturalAlpplyFormMapper;
import com.museum.service.ICulturalAlpplyFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 文创产品申请单 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Service
public class CulturalAlpplyFormServiceImpl extends ServiceImpl<CulturalAlpplyFormMapper, CulturalAlpplyForm> implements ICulturalAlpplyFormService {

    @Override
    public  IPage<CulturalAlpplyForm> findListByPage(Integer page, Integer pageCount){
        IPage<CulturalAlpplyForm> wherePage = new Page<>(page, pageCount);
        CulturalAlpplyForm where = new CulturalAlpplyForm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(CulturalAlpplyForm culturalAlpplyForm){
        return baseMapper.insert(culturalAlpplyForm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(CulturalAlpplyForm culturalAlpplyForm){
        return baseMapper.updateById(culturalAlpplyForm);
    }

    @Override
    public CulturalAlpplyForm findById(Long id){
        return  baseMapper.selectById(id);
    }
}
