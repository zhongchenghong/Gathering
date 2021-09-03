package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PointsMessage对象", description="")
public class PointsMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "横坐标")
    private String abscissa;

    @ApiModelProperty(value = "纵坐标")
    private String ordinate;

    @ApiModelProperty(value = "点位类型id")
    @TableField("map_pointsId")
    private Integer mapPointsid;

    @ApiModelProperty(value = "创建时间")
    private Date createtimes;

    @ApiModelProperty(value = "点位名称")
    private String pointName;

    @ApiModelProperty(value = "点位描述")
    private String pointDescribe;


}
