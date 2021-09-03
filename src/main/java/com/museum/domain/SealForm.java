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
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SealForm对象", description="")
public class SealForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "创建人")
    private Integer uid;

    @ApiModelProperty(value = "部门id")
    private Integer departmentid;

    @ApiModelProperty(value = "经办人1")
    private String name1;

    @ApiModelProperty(value = "经办人2")
    private String name2;

    @ApiModelProperty(value = "1为鲜章，2为钢章")
    private Integer sealtype;

    @ApiModelProperty(value = "用章数量")
    private Integer sealsum;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "事由")
    private String reason;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private String createTime;


}
