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
 * @since 2021-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Procedures对象", description="")
public class Procedures implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "uid")
    private Integer uid;

    @ApiModelProperty(value = "申请类型")
    private String applyType;

    @ApiModelProperty(value = "申请时间")
    private String applyTime;

    @ApiModelProperty(value = "当前角色")
    private Integer roles;

    @ApiModelProperty(value = "审核状态0审批中，1已通过，2未通过")
    private Integer state;

    @ApiModelProperty(value = "流程id")
    private Integer processId;

    @ApiModelProperty(value = "类型id;1、如影像资料申请单")
    private Integer applyTypeid;

    @ApiModelProperty(value = "申请人")
    private String pname;

    @ApiModelProperty(value = "名称")
    private String processName;


}
