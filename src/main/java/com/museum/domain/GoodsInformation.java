package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 信息中心录入物品名称
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GoodsInformation对象", description="信息中心录入物品名称")
public class GoodsInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "物品名称")
    private String goodsName;

    @ApiModelProperty(value = "物品类型")
    private String goodsType;

    @ApiModelProperty(value = "物品数量")
    private Double goodsSum;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;

    @ApiModelProperty(value = "归还时间")
    private String returntime;
}
