package com.museum.dao;

import com.museum.domain.JLProportion;
import com.museum.domain.JlCount;
import com.museum.domain.MerchantStatistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 锦里商户统计、商户列表 Mapper 接口
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
public interface MerchantStatisticsMapper extends BaseMapper<MerchantStatistics> {
    @Select("select count(id) as counts ,merchant_statistics.types as typesname,\n" +
            " cast(count(id)/sums.ii*100 as decimal(9,2)) as  percentage\n" +
            "from merchant_statistics ,\n" +
            "(select count(id) as ii from merchant_statistics) as sums\n" +
            "GROUP BY types")
     List<JlCount> bycount();

    @Select("select name as types,sum(total_money) as money,ROUND(sum(total_money)/summoneys*100,2) as proportion,summoney.summoneys as summoney\n" +
            "from merchant_statistics,\n" +
            "(select SUM(total_money) as summoneys from merchant_statistics) as summoney\n" +
            "GROUP BY types")
     List<JLProportion> byTypesCount();



}
