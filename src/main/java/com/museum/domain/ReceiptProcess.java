package com.museum.domain;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 办公室--收文
 * </p>
 *
 * @author lsj
 * @since 2021-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("receipt_process")
@ApiModel(value="ReceiptProcess对象", description="办公室--收文")
public class ReceiptProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "发起人id")
    private Integer uid;

    @ApiModelProperty(value = "部门主任id")
    private Integer departmentDirectorId;

    @ApiModelProperty(value = "分管馆长id")
    private Integer curatorId;

    @ApiModelProperty(value = "馆长或书记")
    private Integer informationCenter;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "部门主任审核时间")
    private Date departmentDirectorTime;

    @ApiModelProperty(value = "部门主任审核状态 0成功。1失败。2未审核")
    private Integer departmentDirectorState;

    @ApiModelProperty(value = "馆长审核状态0、成功。1、失败。2未审核")
    private Integer informationCenterState;

    @ApiModelProperty(value = "馆长审核时间")
    private String informationCenterTime;

    @ApiModelProperty(value = "收文表id")
    @TableField("image_dataId")
    private Integer imageDataid;

    @ApiModelProperty(value = "发起时间")
    @TableField("createTime")
    private String createTime;

    @ApiModelProperty(value = "部门主任查阅的id")
    @TableField("directorconsultId")
    private Integer directorconsultId;

    @ApiModelProperty(value = "馆长查阅id")
    @TableField("centerconsultId")
    private Integer centerconsultId;

    @ApiModelProperty(value = "分管馆长查阅id")
    @TableField("department_consultId")
    private String departmentConsultid;

    @ApiModelProperty(value = "馆长的备注")
    private String centerRemarks;

    @ApiModelProperty(value = "部门主任的备注")
    private String directorRemarks;

    @ApiModelProperty(value = "部门馆长意见")
    private String curatorRemarks;

    @ApiModelProperty(value = "分馆长审核状态 0成功。1失败。2未审核")
    private Integer departmentCuratorState;

    @ApiModelProperty(value = "分馆长审核时间")
    private Date departmentCuratorTime;


}
