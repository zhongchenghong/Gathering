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

/**
 * <p>
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AccountToken对象", description="")
public class AccountToken<exist>   implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账户")
    @TableField("userName")
    private String userName;


    @ApiModelProperty(value = "创建时间")
    private String createtimes;

    @ApiModelProperty(value = "mac地址")
    private String macid;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "部门id")
    private String department;

    @ApiModelProperty(value = "职位id")
    private String position;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "token")
    private String token;










}
