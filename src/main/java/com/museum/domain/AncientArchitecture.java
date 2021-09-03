package com.museum.domain;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 数据中心-古建数据
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ancient_architecture")
@ApiModel(value="AncientArchitecture对象", description="数据中心-古建数据")
public class AncientArchitecture implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "编号")
    private String num;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "位置")
    private String address;

    @ApiModelProperty(value = "级别")
    private String level;

    @ApiModelProperty(value = "面积")
    private String area;

    private String years;

    @ApiModelProperty(value = "类别")
    private String category;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "现状")
    private String situation;

    @ApiModelProperty(value = "现状描述")
    private String situationDescription;

    @ApiModelProperty(value = "维修记录")
    private String maintainRecords;

    @ApiModelProperty(value = "相关资料")
    private String information;

    @ApiModelProperty(value = "巡检记录")
    private String record;

    @ApiModelProperty(value = "创建时间")
    private String  creatimes;

    @ApiModelProperty(value = "创建人")
    private Integer uid;


}
