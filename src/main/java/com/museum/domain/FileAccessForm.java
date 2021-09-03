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
 * 档案查阅表单
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="FileAccessForm对象", description="档案查阅表单")
public class FileAccessForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "查阅时间")
    private String accesstime;

    @ApiModelProperty(value = "部门id")
    private Integer department;

    @ApiModelProperty(value = "查阅人")
    private String accessName;

    private Integer uid;

    @ApiModelProperty(value = "查阅标题")
    private String accessTitle;

    @ApiModelProperty(value = "查阅数量")
    private Integer accessSum;

    @ApiModelProperty(value = "归还时间")
    private Date returntime;

    @ApiModelProperty(value = "用途")
    private String purpose;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "创建时间")
    private String createtime;


}
