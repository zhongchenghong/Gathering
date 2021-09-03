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
@ApiModel(value="Archives对象", description="")
public class Archives implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账号id")
    private Integer uid;

    @ApiModelProperty(value = "档案名称")
    private String archivesName;

    @ApiModelProperty(value = "借阅名称")
    private String borrowingName;

    @ApiModelProperty(value = "1为查阅，0为借阅")
    private Integer types;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private String createTime;

    @ApiModelProperty(value = "详情")
    private String content;

    @ApiModelProperty(value = "部门")
    private String department;

    @ApiModelProperty(value = "部门id")
    private int departmentId;

    @ApiModelProperty(value = "档案类型分类")
    private String archivesTypeId;

    @ApiModelProperty(value = "借阅/查阅时间")
    private String borrowTime;

    @ApiModelProperty(value = "归还时间")
    private String returnTime;


    @ApiModelProperty(value = "缴纳档案的部门")
    private String payDepartment;





}
