package com.museum.domain;

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
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-07-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Rules对象", description="")
public class Rules implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "规章制度内容")
    private String rulesContext;

    @ApiModelProperty(value = "标题")
    private String rulesTitle;

    @ApiModelProperty(value = "账号id")
    private Integer uid;

    @ApiModelProperty(value = "文件名")
    private String rulesFilename;

    @ApiModelProperty(value = "地址")
    private String rulesAddress;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTimes")
    private String  createTimes;


}
