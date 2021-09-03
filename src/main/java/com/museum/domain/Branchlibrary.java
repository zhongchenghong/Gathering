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
 * 分管馆长跟部门绑定
 * </p>
 *
 * @author lsj
 * @since 2021-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Branchlibrary对象", description="分管馆长跟部门绑定")
public class Branchlibrary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "部门id")
    @TableField("departmentId")
    private Integer departmentId;

    @ApiModelProperty(value = "分馆长id")
    private Integer uid;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private Date createTime;


}
