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
 * 财务用款计划申请流程
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="FinanceApplyPlanProcess对象", description="财务用款计划申请流程")
public class FinanceApplyPlanProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "发起人id")
    private Integer uid;

    @ApiModelProperty(value = "部门主任id")
    private Integer departmentDirectorId;

    @ApiModelProperty(value = "财务部门主任")
    private Integer informationCenter;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "部门主任审核时间")
    private Date departmentDirectorTime;

    @ApiModelProperty(value = "部门主任审核状态 0成功。1失败。2未审核")
    private Integer departmentDirectorState;

    @ApiModelProperty(value = "财务主任审核状态0、成功。1、失败。2未审核")
    private Integer informationCenterState;

    @ApiModelProperty(value = "财务主任审核时间")
    private Date informationCenterTime;

    @ApiModelProperty(value = "表单id")
    @TableField("image_dataId")
    private Integer imageDataid;

    @ApiModelProperty(value = "发起时间")
    @TableField("createTime")
    private String createTime;

    @ApiModelProperty(value = "部门主任查阅的id")
    @TableField("directorconsultId")
    private Integer directorconsultId;

    @ApiModelProperty(value = "财务主任查阅id")
    @TableField("centerconsultId")
    private Integer centerconsultId;

    @ApiModelProperty(value = "资料发放Id")
    @TableField("grantId")
    private Integer grantId;

    @ApiModelProperty(value = "信息中心主人的备注")
    private String centerRemarks;

    @ApiModelProperty(value = "部门主任的备注")
    private String directorRemarks;


}
