package com.museum.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class JlCount {

    @ApiModelProperty(value = "商户类型的家数")
    private String counts;
    @ApiModelProperty(value = "商户类型")
    private String typesname;
    @ApiModelProperty(value = "商户类型占比")
    private String percentage;
}
