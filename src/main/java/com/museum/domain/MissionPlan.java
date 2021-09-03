package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalTime;
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
 * @since 2021-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MissionPlan对象", description="")
public class MissionPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "开始小时")
    @TableField("startTime")
    private String startTime;

    @ApiModelProperty(value = "结束小时")
    @TableField("endTime")
    private String endTime;

    @ApiModelProperty(value = "计划内容")
    private String planContent;

    @ApiModelProperty(value = "任务类型：1为重要事项")
    private String playType;

    @ApiModelProperty(value = "是否处理：1为处理，0为未处理")
    private Integer planstate;

    @ApiModelProperty(value = "开始计划的年月日")
    private String plantime;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;

    @ApiModelProperty(value = "是否同步到待办事项")
    private int synchronizeds;


}
