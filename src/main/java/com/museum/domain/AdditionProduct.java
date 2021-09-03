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
 * 文创产业部-新增产品
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AdditionProduct对象", description="文创产业部-新增产品")
public class AdditionProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "产品名称")
    private String name;

    private Integer uid;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "数量")
    private String sum;

    @ApiModelProperty(value = "上传时间")
    private Date uptime;

    @ApiModelProperty(value = "文件原始名称")
    private String filename;

    @ApiModelProperty(value = "文件地址")
    private String fileaddress;

    @ApiModelProperty(value = "简介")
    private String introduction;


}
