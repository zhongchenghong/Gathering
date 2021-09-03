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
 * 数据中心-非结构化数据
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("not_structure")
@ApiModel(value="NotStructure对象", description="数据中心-非结构化数据")
public class NotStructure implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "部门")
    private String depment;

    @ApiModelProperty(value = "上传人")
    private String userName;

    @ApiModelProperty(value = "文件原始名称")
    private String filename;

    @ApiModelProperty(value = "文件地址")
    private String fileaddress;

    private Integer uid;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;

    @ApiModelProperty(value = "数据类型")
    private String type;


}
