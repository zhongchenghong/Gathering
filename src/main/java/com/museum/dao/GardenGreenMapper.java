package com.museum.dao;

import com.museum.domain.GardenGreen;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lsj
 * @since 2021-08-12
 */
public interface GardenGreenMapper extends BaseMapper<GardenGreen> {
    @Select("select * from garden_green where garden_green.type=#{type}   GROUP BY garden_green.region")
    List<GardenGreen>   getGardenGreenCount(String type);

}
