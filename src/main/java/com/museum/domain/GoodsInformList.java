package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class GoodsInformList implements Serializable {

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

    List<GoodsFormMessage> str;

    @ApiModelProperty(value = "领用类型")
    private int type;


}
