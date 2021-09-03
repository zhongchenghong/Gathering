package com.museum.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *
 */
@Data
public class JLProportion {

    @ApiModelProperty(value = "商户类型")
    private String types;

    @ApiModelProperty(value = "商户单一类型总金额")
    private String money;

    @ApiModelProperty(value = "金额占比")
    private String proportion;

    @ApiModelProperty(value = "总金额")
    private String summoney;
}
