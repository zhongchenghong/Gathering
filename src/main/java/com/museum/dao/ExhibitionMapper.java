package com.museum.dao;

import com.museum.domain.ActivityEntryCountByYear;
import com.museum.domain.Exhibition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 陈列展览表单 Mapper 接口
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
public interface ExhibitionMapper extends BaseMapper<Exhibition> {
    @Select("select  sum(peoplesum) as count,substring(createtime, 1, 4) as year from exhibition GROUP BY  substring(exhibition.createtime, 1, 4)")
    List<ActivityEntryCountByYear> getcountByYear();

    @Select("select count(id) as count,exhibition.exhibitionfathertypename  as exhibitionfathertypename\n" +
            ",substring(createtime, 1, 4) as year from exhibition where #{year}=substring(createtime, 1, 4)\n" +
            " GROUP BY exhibition.exhibitionfathertype")
    List<ActivityEntryCountByYear> getcountBytype(String  year);

}
