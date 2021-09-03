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
 * 办公室加油登记
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="LubricateRecord对象", description="办公室加油登记")
public class LubricateRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;

    @ApiModelProperty(value = "车牌号")
    private String cards;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "经办人")
    private String name;

    @ApiModelProperty(value = "费用")
    private String cost;

    @ApiModelProperty(value = "日期")
    private String inserttimes;

    @ApiModelProperty(value = "备注")
    private String remarks;


}
