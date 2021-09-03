package com.museum.service;

import com.museum.domain.MissionPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-02
 */
public interface IMissionPlanService extends IService<MissionPlan> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<MissionPlan>
     */
    IPage<MissionPlan> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param missionPlan 
     * @return int
     */
    int add(MissionPlan missionPlan);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param missionPlan 
     * @return int
     */
    int updateData(MissionPlan missionPlan);

    /**
     * id查询数据
     *
     * @param id id
     * @return MissionPlan
     */
    MissionPlan findById(Long id);
}
