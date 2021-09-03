package com.museum.domain;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 投诉处理表单
 * </p>
 *
 * @author lsj
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("complaint_form")
@ApiModel(value="ComplaintForm对象", description="投诉处理表单")
public class ComplaintForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "投诉个人或单位")
    private String companyName;

    @ApiModelProperty(value = "来文方式")
    private String mode;

    @ApiModelProperty(value = "工单号")
    private Integer number;

    @ApiModelProperty(value = "创建时间")
    private String  createtime;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "事由")
    private String resource;

    @ApiModelProperty(value = "上传地址")
    private String path;

    @ApiModelProperty(value = "经办人")
    private String agent;

    @ApiModelProperty(value = "原始文件名")
    private String originalfilename;

    @ApiModelProperty(value = "文件名")
    private String filename;

    @ApiModelProperty(value = "uid")
    private Integer uid;


}
