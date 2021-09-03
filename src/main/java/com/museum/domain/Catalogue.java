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
 * 数据中心-目录管理
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Catalogue对象", description="数据中心-目录管理")
public class Catalogue implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父类目录id")
    @TableField("parentId")
    private Integer parentId;

    @ApiModelProperty(value = "目录名称")
    private String name;

    @ApiModelProperty(value = "数据类型:1为保护类，2为服务类，3管理类")
    private String type;

    @ApiModelProperty(value = "目录级别")
    private String catalogueType;

    @ApiModelProperty(value = "创建时间")
    private Date createtimes;


}
