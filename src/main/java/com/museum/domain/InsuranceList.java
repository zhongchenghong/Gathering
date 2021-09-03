package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 办公室车辆保险
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InsuranceList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    @ApiModelProperty(value = "车牌号")
    private String cards;

    @ApiModelProperty(value = "经办人")
    private String name;

    @ApiModelProperty(value = "投保日期")
    private String insureTime;

    private String createtimes;

    @ApiModelProperty(value = "投保电话")
    private String insurancePhone;

    @ApiModelProperty(value = "保费")
    private String cost;

    @ApiModelProperty(value = "投保公司")
    private String company;

    List<Insurance> insurance;


}
