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
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ImageDataProcess对象", description="")
public class ImageDataProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "发起人id")
    private Integer uid;

    @ApiModelProperty(value = "部门主任id")
    private Integer departmentDirectorId;

    @ApiModelProperty(value = "信息中心主任id")
    private Integer informationCenter;

    @ApiModelProperty(value = "部门主任审核时间")
    private String departmentDirectorTime;

    @ApiModelProperty(value = "部门主任审核状态1、成功。0、失败")
    private Integer departmentDirectorState;

    private Integer informationCenterState;

    @ApiModelProperty(value = "信息中心主任审核时间")
    private String informationCenterTime;

    @ApiModelProperty(value = "影像资料申请id")
    @TableField("image_dataId")
    private Integer image_dataId;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "发起时间")
    @TableField("createTime")
    private String  createTime;

    @ApiModelProperty(value = "部门主任查阅id")
    @TableField("directorconsultId")
    private int   directorconsultId;

    @ApiModelProperty(value = "信息中心主任查阅id")
    @TableField("centerconsultId")
    private int  centerconsultId;

    @ApiModelProperty(value = "指定发放人ID")
    @TableField("grantId")
    private int  grantId;

    @ApiModelProperty(value = "部门主任意见")
    @TableField("directorIdea")
    private String  directorIdea;

    @ApiModelProperty(value = "信息中心主任意见")
    @TableField("centerIdea")
    private String  centerIdea;


    @ApiModelProperty(value = "申请人名称")
    @TableField("alppyname")
    private String alppyname;

    @ApiModelProperty(value = "部门主任名称")
    @TableField("buname")
    private String buname;

    @ApiModelProperty(value = "信息中心名称")
    @TableField("xinname")
    private String xinname;





}
