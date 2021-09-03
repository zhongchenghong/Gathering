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
 * 数据中心-电力符合数
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Charge对象", description="数据中心-电力符合数")
public class Charge implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "电力负荷数")
    private Double load;

    @ApiModelProperty(value = "地区")
    private String region;

    @ApiModelProperty(value = "编号")
    private String num;

    @ApiModelProperty(value = "总负荷数")
    private Double total;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;


}
