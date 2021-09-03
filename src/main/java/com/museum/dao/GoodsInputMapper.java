package com.museum.dao;

import com.museum.domain.GoodsInput;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
public interface GoodsInputMapper extends BaseMapper<GoodsInput> {
        @Select("select sum(goods_sum) from goods_information")
        String totail();

        @Select("select sum(goods_sum) from goods_information where goods_type=#{type}")
        String selectBytype(String type);
}
