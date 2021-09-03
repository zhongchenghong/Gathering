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
 * @since 2021-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Screen对象", description="")
public class Screen implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "大屏名称")
    private String screenName;

    @ApiModelProperty(value = "分辨率")
    private String resolvingPower;

    @ApiModelProperty(value = "创建时间")
    private String  createtimes;

    @ApiModelProperty(value = "大屏地址")
    private String screenPosition;

    @ApiModelProperty(value = "页面id")
    private int screenContentid;



}
