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
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DataCollection对象", description="")
public class DataCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "申请时间")
    private String applytime;

    @ApiModelProperty(value = "申请部门")
    private String applydepartment;

    @ApiModelProperty(value = "拍摄时间")
    private Date shottime;

    private String shotname;

    @ApiModelProperty(value = "拍摄类型")
    private Integer shottype;

    @ApiModelProperty(value = "拍摄内容")
    private String shotcontent;

    @ApiModelProperty(value = "提供部门")
    private Integer pdepartment;

    @ApiModelProperty(value = "资料数量")
    private Integer sum;

    @ApiModelProperty(value = "完成情况")
    private String complete;


}
