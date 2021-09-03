package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 活动录入
 * </p>
 *
 * @author lsj
 * @since 2021-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Statistics", description="固产耗材统计")
public class Statistics implements Serializable {


    @ApiModelProperty(value = "总数量")
    private String total;

    @ApiModelProperty(value = "固产")
    private String guchan;

    @ApiModelProperty(value = "耗材")
    private String haocai;
}
