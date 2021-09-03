package com.museum.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="视频图像返回地址", description="")
public class PictureOVVoide {
    @ApiModelProperty(value = "图片视频地址")
    private String url;
    @ApiModelProperty(value = "图片视频文字说明")
    private String alt;
    @ApiModelProperty(value = "跳转链接")
    private String href;
}
