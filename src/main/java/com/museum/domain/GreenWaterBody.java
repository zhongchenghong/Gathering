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
 * 数据中心-绿地水体面积
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GreenWaterBody对象", description="数据中心-绿地水体面积")
public class GreenWaterBody implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "区域")
    private String region;

    private Double area;

    @ApiModelProperty(value = "分区面积")
    private Double partitionArea;

    @ApiModelProperty(value = "总面积")
    private Double total;

    @ApiModelProperty(value = "创建时间")
    private String creatimes;

    @ApiModelProperty(value = "0为绿地，1为水体")
    private String type;


}
