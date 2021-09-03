package com.museum.domain;

import java.util.Date;
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
 * @since 2021-07-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="InternalControl对象", description="")
public class InternalControl implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "创建者id")
    private Integer uid;

    @ApiModelProperty(value = "制度名称")
    private String  institutionTitle;

    @ApiModelProperty(value = "制度内容")
    private String  institutionContext;

    @ApiModelProperty(value = "原始名称")
    private String fileName;

    @ApiModelProperty(value = "文件地址")
    private String fileAddress;

    @ApiModelProperty(value = "创建时间")
    private String  createtimes;


}
