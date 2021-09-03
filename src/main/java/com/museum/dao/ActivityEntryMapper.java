package com.museum.dao;

import com.museum.domain.ActivityEntry;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.museum.domain.ActivityEntryCountByYear;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 活动录入 Mapper 接口
 * </p>
 *
 * @author lsj
 * @since 2021-08-03
 */
public interface ActivityEntryMapper extends BaseMapper<ActivityEntry> {
    @Select("select  count(id) as count,substring(createtimes, 1, 4) as year from activity_entry GROUP BY  substring(activity_entry.createtimes, 1, 4)")
    List<ActivityEntryCountByYear> selectCountByYear();

}
