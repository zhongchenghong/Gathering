package com.museum.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 发文申请
 * </p>
 *
 * @author lsj
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("post_form")
@ApiModel(value="PostForm对象", description="发文申请")
public class PostForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "部门id")
    private Integer department;

    @ApiModelProperty(value = "起草人")
    private String draftName;

    @ApiModelProperty(value = "申请时间")
    @TableField("applyTime")
    private Date applyTime;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "地址")
    private String path;

    @ApiModelProperty(value = "原始文件名")
    private String filename;

    private Integer uid;


}
