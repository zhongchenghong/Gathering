package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 物品领用
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GoodsInform对象", description="物品领用")
public class GoodsInform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "领用时间")
    private Date claimTime;

    @ApiModelProperty(value = "领用人")
    private String claimName;

    @ApiModelProperty(value = "物品id")
    private Integer goodsInformationId;

    @ApiModelProperty(value = "领用数量")
    private Integer sum;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;

    private Integer uid;


    @ApiModelProperty(value = "领用类型")
    private String type;

    @ApiModelProperty(value = "审核状态")
    private int state;


}
