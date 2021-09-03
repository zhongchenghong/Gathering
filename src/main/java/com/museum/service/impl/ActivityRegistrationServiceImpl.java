package com.museum.service.impl;

import com.museum.domain.ActivityRegistration;
import com.museum.dao.ActivityRegistrationMapper;
import com.museum.service.IActivityRegistrationService;
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
 * @since 2021-08-05
 */
@Service
public class ActivityRegistrationServiceImpl extends ServiceImpl<ActivityRegistrationMapper, ActivityRegistration> implements IActivityRegistrationService {

    @Override
    public  IPage<ActivityRegistration> findListByPage(Integer page, Integer pageCount){
        IPage<ActivityRegistration> wherePage = new Page<>(page, pageCount);
        ActivityRegistration where = new ActivityRegistration();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ActivityRegistration activityRegistration){
        return baseMapper.insert(activityRegistration);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ActivityRegistration activityRegistration){
        return baseMapper.updateById(activityRegistration);
    }

    @Override
    public ActivityRegistration findById(Long id){
        return  baseMapper.selectById(id);
    }
}
