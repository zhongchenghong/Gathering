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
@ApiModel(value="ImageData对象", description="")
public class ImageData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "申请人id")
    private Integer uid;

    @ApiModelProperty(value = "完成情况")
    private String completion;

    @ApiModelProperty(value = "用途")
    private String purpose;

    @ApiModelProperty(value = "映像资料内容")
    @TableField("Image_data_content")
    private String imageDataContent;

    @ApiModelProperty(value = "部门id")
    @TableField("departmentId")
    private Integer departmentId;

    @ApiModelProperty(value = "审核状态")
    @TableField("state")
    private Integer state;



    @ApiModelProperty(value = "申请时间")
    @TableField("applyTime")
    private Date applyTime;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private String createTime;


    @ApiModelProperty(value = "人名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "文件名称")
    @TableField("filename")
    private String fileName;


}
