package com.museum.domain;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2021-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("testing_equipment_data")
@ApiModel(value="TestingEquipmentData对象", description="")
public class TestingEquipmentData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "数据单位")
    @TableField("eUnit")
    private String eUnit;

    @TableField("eValue")
    private String eValue;

    @TableField("eKey")
    private String eKey;

    @TableField("eName")
    private String eName;

    @ApiModelProperty(value = "通道对应编码")
    @TableField("eNum")
    private String eNum;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;

    @ApiModelProperty(value = "设备类型")
    private String equipmenttype;

    @ApiModelProperty(value = "设备名称")
    private String equipmentname;

    private Integer typeid;

    @ApiModelProperty(value = "时间")
    private String datetime;
}
