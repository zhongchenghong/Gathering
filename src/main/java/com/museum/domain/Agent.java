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
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Agent对象", description="")
public class Agent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "代办事项标题")
    private String titles;

    @ApiModelProperty(value = "提交时间")
    private String  createtimes;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "提交人id")
    private Integer uid;

    @ApiModelProperty(value = "1为代办事项")
    private Integer agentType;

    @ApiModelProperty(value = "日程安排id")
    private Integer missionPlanId;

    @ApiModelProperty(value = "待办事项状态")
    private Integer state;

    @ApiModelProperty(value = "影像资料申请单id")
    private Integer imageDataId;

    @ApiModelProperty(value = "发起人id")
    private Integer submitid;
    @ApiModelProperty(value = "提交人")
    private String submitname;

    @ApiModelProperty(value = "职位")
    private String  position;

    @ApiModelProperty(value = "提交人显示")
    private String names;

    @ApiModelProperty(value = "处理时间")
    private String chulitime;

    @ApiModelProperty(value = "发起时间")
    private String faqitime;

    @ApiModelProperty(value = "资料内容")
    private String imageContent;

    @ApiModelProperty(value = "流程id")
    private String imageDataPro;

}
