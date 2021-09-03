package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Releases对象", description="")
public class Releases implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "发布类型：1图片，2视频，3文字")
    private Integer types;

    @ApiModelProperty(value = "屏幕标号")
    private Integer numbers;

    @ApiModelProperty(value = "上传的用户id")
    private Integer uid;


}
