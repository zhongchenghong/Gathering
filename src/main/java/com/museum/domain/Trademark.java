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
 * 文创产业部商标添加
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Trademark对象", description="文创产业部商标添加")
public class Trademark implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "trademark")
    private String trademark;

    @ApiModelProperty(value = "类别")
    private String type;

    @ApiModelProperty(value = "注册号")
    private String registrationNumber;

    @ApiModelProperty(value = "申请时间")
    private Date applyTime;

    @ApiModelProperty(value = "注册日期")
    private Date registrationTime;

    @ApiModelProperty(value = "到期时间")
    private Date expireTime;

    @ApiModelProperty(value = "商品介绍")
    private String introduce;

    private Integer uid;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;


}
