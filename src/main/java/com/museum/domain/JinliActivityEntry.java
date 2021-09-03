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
 * 锦里公司活动录入
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="JinliActivityEntry对象", description="锦里公司活动录入")
public class JinliActivityEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "开始时间")
    @TableField("startTime")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("endTime")
    private String endTime;

    @ApiModelProperty(value = "活动名称")
    private String activityName;

    @ApiModelProperty(value = "发布者id")
    @TableField("publisherId")
    private Integer publisherId;

    @ApiModelProperty(value = "活动介绍")
    private String introduce;

    private Integer uid;

    @ApiModelProperty(value = "原始文件名")
    private String filename;

    @ApiModelProperty(value = "上传地址")
    private String fileaddress;

    @ApiModelProperty(value = "创建时间")
    private String createtime;

    @ApiModelProperty(value = "活动状态")
    private int state;


}
