package com.museum.service.impl;

import com.museum.domain.ActivityEntry;
import com.museum.dao.ActivityEntryMapper;
import com.museum.domain.ActivityEntryCountByYear;
import com.museum.service.IActivityEntryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * <p>
 * 活动录入 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-03
 */
@Service
public class ActivityEntryServiceImpl extends ServiceImpl<ActivityEntryMapper, ActivityEntry> implements IActivityEntryService {

    @Override
    public  IPage<ActivityEntry> findListByPage(Integer page, Integer pageCount){
        IPage<ActivityEntry> wherePage = new Page<>(page, pageCount);
        ActivityEntry where = new ActivityEntry();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ActivityEntry activityEntry){
        return baseMapper.insert(activityEntry);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ActivityEntry activityEntry){
        return baseMapper.updateById(activityEntry);
    }

    @Override
    public ActivityEntry findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<ActivityEntryCountByYear> selectCountByYearIService() {
        return baseMapper.selectCountByYear();
    }
}
