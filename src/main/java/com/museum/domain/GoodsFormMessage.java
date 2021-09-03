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
 * @since 2021-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GoodsFormMessage对象", description="")
public class GoodsFormMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "1为固材，2为耗材")
    private String type;

    @ApiModelProperty(value = "物品名称")
    private String name;

    @ApiModelProperty(value = "领用数量")
    private String sum;

    @ApiModelProperty(value = "物品表单名称")
    private Integer goodsInformId;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;


}
