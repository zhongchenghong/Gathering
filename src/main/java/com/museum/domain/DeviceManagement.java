package com.museum.domain;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 信息中心设备管理
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeviceManagement对象", description="信息中心设备管理")
public class DeviceManagement implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "设备类型")
    private String type;

    @ApiModelProperty(value = "设备编号")
    private String number;

    @ApiModelProperty(value = "设备地址")
    private String address;

    @ApiModelProperty(value = "创建时间")
    private Date createtimes;


}
