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
 * 园林景观-新增植物
 * </p>
 *
 * @author lsj
 * @since 2021-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GardenPlants对象", description="园林景观-新增植物")
public class GardenPlants implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    @ApiModelProperty(value = "植物名称")
    private String name;

    @ApiModelProperty(value = "胸径")
    private String diameter;

    @ApiModelProperty(value = "科")
    private String section;

    @ApiModelProperty(value = "属")
    private String genus;

    @ApiModelProperty(value = "习性")
    private String habit;

    @ApiModelProperty(value = "别称")
    private String nickname;

    @ApiModelProperty(value = "数目介绍")
    private String introduce;

    @ApiModelProperty(value = "创建时间")
    private String createtime;

    @ApiModelProperty(value = "纵坐标")
    private String ordinate;

    @ApiModelProperty(value = "横坐标")
    private String abscissa;

    @ApiModelProperty(value = "拉丁文")
    private String latin;

    @ApiModelProperty(value = "备注")
    private String remarks;



}
