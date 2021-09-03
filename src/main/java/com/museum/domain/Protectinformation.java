package com.museum.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Protectinformation对象", description="")
public class Protectinformation {

    private Integer uid;

    private String url;

    private String username;

    private String signature;

    private String timestamp;
}
