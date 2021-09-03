package com.museum.domain;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 活动录入
 * </p>
 *
 * @author lsj
 * @since 2021-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ActivityEntry对象", description="活动录入")
public class ActivityEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    @ApiModelProperty(value = "开始时间")
    private String starttime;

    @ApiModelProperty(value = "结束时间")
    private String endtime;

    @ApiModelProperty(value = "活动名称")
    private String name;

    @ApiModelProperty(value = "发布者")
    private String release;

    @ApiModelProperty(value = "活动地址")
    private String activityAddress;

    @ApiModelProperty(value = "人数")
    private String peopleSum;

    @ApiModelProperty(value = "文件原始名称")
    private String filename;

    @ApiModelProperty(value = "文件地址")
    private String fileaddress;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;

    @ApiModelProperty(value = "活动状态")
    private int state;
}
