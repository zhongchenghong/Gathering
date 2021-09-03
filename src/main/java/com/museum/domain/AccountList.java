package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="通讯录查询对象", description="")
public class AccountList implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableField("id")
    private String id;

    @ApiModelProperty(value = "账户")
    @TableField("userName")
    private String userName;

    @ApiModelProperty(value = "部门")
    @TableField("departmentName")
    private String departmentName;

    @ApiModelProperty(value = "职位")
    @TableField("positionName")
    private String positionName;

    @ApiModelProperty(value = "手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "固话")
    @TableField("fixed_line")
    private String fixedLine;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "分组")
    @TableField("mailListName")
    private String mailListName;

}
