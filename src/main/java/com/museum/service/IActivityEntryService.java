package com.museum.service;

import com.museum.domain.ActivityEntry;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.museum.domain.ActivityEntryCountByYear;

import java.util.List;

/**
 * <p>
 * 活动录入 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-03
 */
public interface IActivityEntryService extends IService<ActivityEntry> {

    /**
     * 查询活动录入分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ActivityEntry>
     */
    IPage<ActivityEntry> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加活动录入
     *
     * @param activityEntry 活动录入
     * @return int
     */
    int add(ActivityEntry activityEntry);

    /**
     * 删除活动录入
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改活动录入
     *
     * @param activityEntry 活动录入
     * @return int
     */
    int updateData(ActivityEntry activityEntry);

    /**
     * id查询数据
     *
     * @param id id
     * @return ActivityEntry
     */
    ActivityEntry findById(Long id);

    /**
     * 通过年统计数量
     */
    List<ActivityEntryCountByYear> selectCountByYearIService();
}
