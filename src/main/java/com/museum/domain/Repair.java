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
 * 办公室维保登记
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Repair对象", description="办公室维保登记")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    @ApiModelProperty(value = "车牌号")
    private String cards;

    @ApiModelProperty(value = "维保类型")
    private String type;

    @ApiModelProperty(value = "经办人")
    private String name;

    @ApiModelProperty(value = "联系方式")
    private String phone;

    @ApiModelProperty(value = "维修时间")
    private Date repairTime;

    @ApiModelProperty(value = "维修单位")
    private String repairDepartment;

    @ApiModelProperty(value = "维修费用")
    private String cost;

    @ApiModelProperty(value = "备注")
    private String remarks;


}
