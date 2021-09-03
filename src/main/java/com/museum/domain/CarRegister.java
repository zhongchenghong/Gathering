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
 * 新车登记
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CarRegister对象", description="新车登记")
public class CarRegister implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "车牌号")
    private String cards;

    @ApiModelProperty(value = "发动机号")
    private String engine;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "颜色")
    private String colour;

    @ApiModelProperty(value = "载客数")
    private String passenger;

    @ApiModelProperty(value = "车型")
    private String model;

    @ApiModelProperty(value = "排量")
    private String displacement;

    @ApiModelProperty(value = "购买时间")
    private String  buytime;

    @ApiModelProperty(value = "年检时间")
    private String inspectiontime;

    @ApiModelProperty(value = "燃料类型")
    private String fuelType;

    @ApiModelProperty(value = "默认耗油")
    private String fuel;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;

    @ApiModelProperty(value = "图片原始名称")
    private String name;

    @ApiModelProperty(value = "图片地址")
    private String address;

    @ApiModelProperty(value = "uid")
    private int uid;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "允许使用成员")
    private String jurisdiction;

}
