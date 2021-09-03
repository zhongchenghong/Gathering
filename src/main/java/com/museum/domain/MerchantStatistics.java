package com.museum.domain;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 锦里商户统计、商户列表
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("merchant_statistics")
@ApiModel(value="MerchantStatistics对象", description="锦里商户统计、商户列表")
public class MerchantStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商户名称")
    private String name;

    @ApiModelProperty(value = "商户类型")
    private String types;

    private Double totalMoney;

    @ApiModelProperty(value = "交易单数")
    private Double singular;

    @ApiModelProperty(value = "平均每单金额")
    private String averageSingular;

    @ApiModelProperty(value = "创建时间")
    private Date createtimes;


}
