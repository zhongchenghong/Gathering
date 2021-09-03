package com.museum.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 保护信息管理系统设备管理
 * </p>
 *
 * @author lsj
 * @since 2021-08-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TestingEquipment对象", description="保护信息管理系统设备管理")
public class TestingEquipment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "设备id")
    @TableField("equipmentId")
    private Integer equipmentId;

    @ApiModelProperty(value = "设备类型")
    private String equipmenttype;

    @ApiModelProperty(value = "设备名称")
    private String equipmentname;

    @ApiModelProperty(value = "创建时间")
    private Date createtimes;

    @ApiModelProperty(value = "设备类型：1为气象监测，2为气体综合监测，3为温湿度无线网关")
    @TableField("equipmenttypeId")
    private Integer equipmenttypeId;


}
