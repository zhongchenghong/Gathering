package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.poi.ss.usermodel.CellStyle;

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
@ApiModel(value="Account对象", description="")
public class Account<exist>   implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账户")
    @TableField("userName")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;

    @ApiModelProperty(value = "mac地址")
    private String macid;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "验证码")
    private String code;

    @ApiModelProperty(value = "获取验证码时间")
    private String codecreatetime;

    @ApiModelProperty(value = "固话")
    private String fixedLine;

    @ApiModelProperty(value = "部门id")
    private String departmentId;

    @ApiModelProperty(value = "职位id")
    private String positionId;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "过期时间")
    private String expirationTime;

    @ApiModelProperty(value = "待办状态")
    private int agencyState;

    @ApiModelProperty(value = "待办开始时间")
    private String agencystarttime;

    @ApiModelProperty(value = "待办开始时间")
    private String agencyendtime;

    @ApiModelProperty(value = "待办人id")
    private int agencyUid;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "部门")
    private String departmentName;


    @ApiModelProperty(value = "头像地址")
    private String picture;









}
