package com.museum.dao;

import com.museum.domain.OfficeGoodsInput;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 办公室物品录入 Mapper 接口
 * </p>
 *
 * @author lsj
 * @since 2021-08-19
 */
public interface OfficeGoodsInputMapper extends BaseMapper<OfficeGoodsInput> {
    @Select("select goods1.name, goods1.goodsum1,goods1.unit11,\n" +
            "\t\t\t goods2.goodsum2,goods2.unit12,\n" +
            "       goods3.goodsum3,goods3.unit13,\n" +
            "       goos14.goodsum4,goos14.unit14\n" +
            "from \n" +
            "(SELECT sum(office_goods_input.goodsum)  as goodsum1 ,office_goods_input.unit as  unit11,office_goods_input.name as  name from  office_goods_input \n" +
            "where  office_goods_input.createtimes LIKE \"%#{createtimes}%\" and office_goods_input.claim_state =\"1\" ) as goods1,\n" +
            "(SELECT sum(office_goods_input.goodsum) as goodsum2,office_goods_input.unit as  unit12\n" +
            " from  office_goods_input where  office_goods_input.createtimes LIKE \"#{createtimes}%\"\n" +
            "and office_goods_input.claim_state =\"0\") as goods2,\n" +
            "(SELECT sum(office_goods_input.goodsum) as goodsum3,office_goods_input.unit as  unit13 \n" +
            "from  office_goods_input where  office_goods_input.createtimes LIKE \"#{uptimes}%\") as goods3,\n" +
            "(SELECT sum(office_goods_input.goodsum) as goodsum4,office_goods_input.unit as  unit14\n" +
            " from  office_goods_input ) as goos14")
            void getMessage(@Param("createtimes")String createtimes,@Param("createtimes")String uptimes,@Param("name")String name,@Param("goodsid")String goodsid);

}
