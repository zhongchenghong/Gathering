package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="设备告警信息", description="")
public class AlarmMessage  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "设备类型")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "区域")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "事件")
    @TableField("events")
    private String events;

    @ApiModelProperty(value = "状态")
    @TableField("state")
    private String state;


    @ApiModelProperty(value = "创建时间")
    @TableField("createtimes")
    private String createtimes;








}
