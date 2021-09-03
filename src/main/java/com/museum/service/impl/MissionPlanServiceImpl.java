package com.museum.service.impl;

import com.museum.domain.MissionPlan;
import com.museum.dao.MissionPlanMapper;
import com.museum.service.IMissionPlanService;
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
 * @since 2021-07-02
 */
@Service
public class MissionPlanServiceImpl extends ServiceImpl<MissionPlanMapper, MissionPlan> implements IMissionPlanService {

    @Override
    public  IPage<MissionPlan> findListByPage(Integer page, Integer pageCount){
        IPage<MissionPlan> wherePage = new Page<>(page, pageCount);
        MissionPlan where = new MissionPlan();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(MissionPlan missionPlan){
        return baseMapper.insert(missionPlan);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(MissionPlan missionPlan){
        return baseMapper.updateById(missionPlan);
    }

    @Override
    public MissionPlan findById(Long id){
        return  baseMapper.selectById(id);
    }
}
