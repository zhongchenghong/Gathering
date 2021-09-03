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
 * @since 2021-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GardenGreen对象", description="")
public class GardenGreen implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "区域")
    private String region;

    @ApiModelProperty(value = "类别")
    private String types;

    @ApiModelProperty(value = "面积")
    private String area;

    @ApiModelProperty(value = "分区面积")
    private String regionArea;

    private String totalArea;

    @ApiModelProperty(value = "1为水体，2为绿化")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    private Date createtimes;


}
