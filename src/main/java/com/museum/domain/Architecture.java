package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 数据中心-古建数据
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Architecture对象", description="数据中心-古建数据")
public class Architecture implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "面积")
    private String area;

    @ApiModelProperty(value = "级别")
    private String level;

    @ApiModelProperty(value = "年代")
    private String years;

    @ApiModelProperty(value = "类别")
    private String type;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "现状")
    private String situation;

    @ApiModelProperty(value = "维修记录")
    private String maintenance;

    @ApiModelProperty(value = "相关材料")
    private String materials;

    @ApiModelProperty(value = "巡检记录")
    @TableField("Inspection")
    private String Inspection;


}
