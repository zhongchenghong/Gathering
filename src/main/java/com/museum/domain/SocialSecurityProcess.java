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
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SocialSecurityProcess对象", description="")
public class SocialSecurityProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "类型")
    private String socialType;

    @ApiModelProperty(value = "标题")
    private String socialTitle;

    @ApiModelProperty(value = "内容")
    private String socialContent;

    @ApiModelProperty(value = "上传地址")
    private String socialPath;

    @ApiModelProperty(value = "文件原始名")
    private String socialFileName;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;


}
