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
@ApiModel(value="ScreenContent和Screen对象", description="")
public class ScreenVOScreenContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "编辑者")
    private Integer uid;

    private Integer screenId;

    @ApiModelProperty(value = "发布内容")
    private String screenContent;

    @ApiModelProperty(value = "分发图片id")
    private String screenPictureid;

    @ApiModelProperty(value = "发布视频id")
    private String screenVoideid;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;
    

    @ApiModelProperty(value = "大屏名称")
    private String screenName;

    @ApiModelProperty(value = "分辨率")
    private String resolvingPower;


    @ApiModelProperty(value = "大屏地址")
    private String screenPosition;

    @ApiModelProperty(value = "页面id")
    private String screenContentid;


}
