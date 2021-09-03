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
@ApiModel(value="DeviceAlarm对象", description="")
public class DeviceAlarm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "事件类型")
    private String type;

    @ApiModelProperty(value = "事件")
    private String events;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "创建时间")
    private Date createtimes;

    @ApiModelProperty(value = "设备编号")
    private String deviceNum;


}
