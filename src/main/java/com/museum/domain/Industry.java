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
 * 文创产业部产业添加
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Industry对象", description="文创产业部产业添加")
public class Industry implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "房产名称")
    private String name;

    @ApiModelProperty(value = "房产地址")
    private String address;

    @ApiModelProperty(value = "产权所有人及证号")
    private String card;

    private String area;

    @ApiModelProperty(value = "账面原值")
    private String value;

    @ApiModelProperty(value = "使用情况")
    private String usage;

    @ApiModelProperty(value = "出租情况")
    private String situation;

    @ApiModelProperty(value = "代管人")
    private String escrowAgent;

    @ApiModelProperty(value = "合同期限")
    private String term;

    @ApiModelProperty(value = "缴费期限")
    private Date paymentPeriod;

    @ApiModelProperty(value = "已缴费租期")
    private String leaseTerm;

    @ApiModelProperty(value = "年租金")
    private String rent;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private Integer uid;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;


}
