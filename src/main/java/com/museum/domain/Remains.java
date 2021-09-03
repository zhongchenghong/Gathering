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
 * 数据中心-遗存调查数据
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Remains对象", description="数据中心-遗存调查数据")
public class Remains implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "编号")
    private String num;

    @ApiModelProperty(value = "地点")
    private String address;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "线路")
    private String line;

    @ApiModelProperty(value = "原始文件名")
    private String filename;

    @ApiModelProperty(value = "文件地址")
    private String fileaddress;

    private Integer uid;

    private String createtimes;


}
