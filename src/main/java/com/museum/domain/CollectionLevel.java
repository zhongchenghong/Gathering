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
 * 藏品级别统计
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CollectionLevel对象", description="藏品级别统计")
public class CollectionLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    @ApiModelProperty(value = "入藏年度")
    private Integer collectionYear;

    @ApiModelProperty(value = "藏品传统总数")
    private Integer collectionTraditionSum;

    @ApiModelProperty(value = "藏品实际总数")
    private Integer collectionActualSum;

    @ApiModelProperty(value = "旧藏(传统)")
    private Integer oldCollectionTradition;

    @ApiModelProperty(value = "一级(实际)")
    private Integer oneLevelActual;

    @ApiModelProperty(value = "二级(传统)")
    private Integer twoLevelTradition;

    @ApiModelProperty(value = "二级(实际)")
    private Integer twoLevelActual;

    @ApiModelProperty(value = "三级(传统)")
    private Integer threeLevelTradition;

    @ApiModelProperty(value = "三级(实际)")
    private Integer threeLevelActual;

    @ApiModelProperty(value = "一般(传统)")
    private Integer commonlyTradition;

    @ApiModelProperty(value = "一般(实际)")
    private Integer commonlyActual;

    @ApiModelProperty(value = "未定级(传统)")
    private Integer undefinedTradition;

    @ApiModelProperty(value = "未定级(实际)")
    private Integer undefinedActual;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;


}
