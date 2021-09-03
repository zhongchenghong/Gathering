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
 * 锦里公司安全记录检查表
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SecurityCheck对象", description="锦里公司安全记录检查表")
public class SecurityCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    @ApiModelProperty(value = "检查日期")
    @TableField("inspectTime")
    private String inspectTime;

    @ApiModelProperty(value = "领导")
    @TableField("leader")
    private String leader;

    @ApiModelProperty(value = "部门")
    @TableField("department")
    private String department;

    @ApiModelProperty(value = "安全隐患和整改措施")
    private String measures;

    @ApiModelProperty(value = "复查情况")
    private String review;

    @ApiModelProperty(value = "复查日期")
    @TableField("reviewTime")
    private String reviewTime;

    @ApiModelProperty(value = "复查人")
    private String reviewName;

    @ApiModelProperty(value = "创建日期")
    private String createtimes;


}
