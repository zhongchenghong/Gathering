package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 物品列表
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CulturalList对象", description="物品列表")
public class CulturalList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "物品编号")
    private String num;

    @ApiModelProperty(value = "物品名称")
    private String name;

    @ApiModelProperty(value = "物品价格")
    private String price;

    @ApiModelProperty(value = "数量")
    private String sum;


}
