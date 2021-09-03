package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Visits对象", description="")
public class Visits implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "访问量名称id")
    @TableField("visitsId")
    private Integer visitsId;

    @ApiModelProperty(value = "年")
    private String years;

    @ApiModelProperty(value = "日")
    private String dates;

    @ApiModelProperty(value = "月")
    private String month;

    @ApiModelProperty(value = "年访问量")
    private Integer yearSum;

    @ApiModelProperty(value = "日访问量")
    private Integer dateSum;

    @ApiModelProperty(value = "月访问量")
    private Integer monthSum;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private String createTime;


}
