package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ScreenResourcesData", description="")
public class ScreenResourcesData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "地址")
    private String readdress;

    @ApiModelProperty(value = "文件类型：1、图片、2为视频、3、文件 4、zip")
    private Integer types;

    @ApiModelProperty(value = "部门")
    private String  department;

    @ApiModelProperty(value = "时间")
    private Date times;

    @ApiModelProperty(value = "原始文件名")
    private String filename;

    @ApiModelProperty(value = "文件地址")
    private String pathaddress;


}
