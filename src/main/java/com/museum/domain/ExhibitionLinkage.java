package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 陈列展览三级联动
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ExhibitionLinkage对象", description="陈列展览三级联动")
public class ExhibitionLinkage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父类id")
    @TableField("exhibitionId")
    private Integer exhibitionId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "0代表一级，1代表二级，2代表三级")
    private String typeid;


}
