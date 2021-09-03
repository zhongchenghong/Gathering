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
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CarForm对象", description="")
public class CarForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "部门id")
    private Integer departmentid;

    @ApiModelProperty(value = "用车人数")
    private Integer peoplesum;

    @ApiModelProperty(value = "里程")
    private Double mileage;

    @ApiModelProperty(value = "目的地")
    private String address;

    @ApiModelProperty(value = "开始时间")
    @TableField("startTime")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("endTime")
    private String  endTime;

    @ApiModelProperty(value = "线路")
    private String line;

    @ApiModelProperty(value = "事由")
    private String reason;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;


}
