package com.museum.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文化公司产品收入
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("product_income")
@ApiModel(value="ProductIncome对象", description="文化公司产品收入")
public class ProductIncome implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "销售数量")
    private Integer saleSum;

    @ApiModelProperty(value = "销售折扣")
    private String saleDiscount;

    @ApiModelProperty(value = "金额")
    private String money;

    @ApiModelProperty(value = "1代表线上，2代表线下")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    private Date createtimes;


}
