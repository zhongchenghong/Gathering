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
 * 陈列展览表单
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Exhibition对象", description="陈列展览表单")
public class Exhibition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "提交人")
    private Integer uid;

    @ApiModelProperty(value = "展览类型")
    @TableField("exhibitionType")
    private String exhibitionType;

    @ApiModelProperty(value = "开始时间")
    @TableField("startTime")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("endTime")
    private String  endTime;

    @ApiModelProperty(value = "展览内容")
    private String exhibitionContent;

    @ApiModelProperty(value = "原始文件名")
    private String filename;

    @ApiModelProperty(value = "文件地址")
    private String fileaddress;

    @ApiModelProperty(value = "展览类型名称")
    private String exhibitionTypeName;

    @ApiModelProperty(value = "创建时间")
    private String createtime;

    @ApiModelProperty(value = "展览人数")
    private Integer peoplesum;

    @ApiModelProperty(value = "展览名称")
    private String name;

    @ApiModelProperty(value = "父类id")
    private Integer exhibitionfathertype;

    @ApiModelProperty(value = "父类名称")
    private String exhibitionfathertypename;


}
