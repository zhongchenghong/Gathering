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
 * 用款计划申请
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="FinanceApplyPlan对象", description="用款计划申请")
public class FinanceApplyPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @ApiModelProperty(value = "申请时间")
    private String applicationTime;

    @ApiModelProperty(value = "申请金额")
    private Double money;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;


    @ApiModelProperty(value = "uid")
    private Integer uid;


}
