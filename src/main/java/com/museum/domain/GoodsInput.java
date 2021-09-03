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
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GoodsInput对象", description="")
public class GoodsInput implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "录入时间")
    private String inserttime;

    @ApiModelProperty(value = "录入人")
    private String insertname;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private String  createtimes;

    @ApiModelProperty(value = "物品id")
    private Integer goodsid;

    @ApiModelProperty(value = "物品数量")
    private Double goodsum;

    @ApiModelProperty(value = "领用人")
    private String claimName;

    @ApiModelProperty(value = "领用状态")
    private int claimState;


}
