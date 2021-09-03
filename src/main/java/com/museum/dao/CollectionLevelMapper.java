package com.museum.dao;

import com.museum.domain.CollectionLevel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 藏品级别统计 Mapper 接口
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
public interface CollectionLevelMapper extends BaseMapper<CollectionLevel> {
    @Select("select sum(one_level_actual) one,\n" +
            "sum(two_level_tradition) two_level_tradition,sum(two_level_actual) two_level_actual,\n" +
            "sum(three_level_tradition) three_level_tradition,sum(three_level_actual) three_level_actual,\n" +
            "sum(collection_tradition_sum)+sum(collection_actual_sum) collection_tradition_sum,\n" +
            "sum(old_collection_tradition) old_collection_tradition,\n" +
            "sum(commonly_tradition)+sum(commonly_actual)+sum(undefined_tradition)+sum(undefined_actual) undefined_actual\n" +
            " from collection_level")
    CollectionLevel getSum();
}
