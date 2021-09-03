package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GoodsInputList", description="")
public class GoodsInputList implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "录入时间")
    private String inserttime;

    @ApiModelProperty(value = "录入人")
    private String insertname;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private Date createtimes;

    @ApiModelProperty(value = "物品id")
    private Integer goodsid;

    @ApiModelProperty(value = "物品数量")
    private Integer goodsum;
    //物品列表
    private List<GoodsInformation> ls;


}
