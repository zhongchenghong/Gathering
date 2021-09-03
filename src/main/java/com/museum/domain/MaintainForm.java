package com.museum.domain;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 软硬件维护维修申请单
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MaintainForm对象", description="软硬件维护维修申请单")
public class MaintainForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "申请时间")
    private Integer id;

    private Integer uid;

    private String createtime;

    @ApiModelProperty(value = "申请部门")
    private Integer department;

    @ApiModelProperty(value = "申请部门")
    private String departmentName;

    @ApiModelProperty(value = "维护时间")
    private Date maintainTime;

    @ApiModelProperty(value = "维护地址")
    private String address;

    @ApiModelProperty(value = "维护内容")
    private String maintainIdea;

    @ApiModelProperty(value = "完成情况")
    private String completion;


}
