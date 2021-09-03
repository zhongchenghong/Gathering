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
 * 文化公司驾驶舱-产品目录
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("product_catalog")
@ApiModel(value="ProductCatalog对象", description="文化公司驾驶舱-产品目录")
public class ProductCatalog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "产品名称")
    private String name;

    @ApiModelProperty(value = "产品图品")
    private String picture;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "总数量")
    private Integer sum;

    @ApiModelProperty(value = "剩余数量")
    private Integer surplusSum;

    @ApiModelProperty(value = "供应商")
    private String supply;

    private Integer uid;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;


}
