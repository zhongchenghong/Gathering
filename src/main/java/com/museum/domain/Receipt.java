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
 * 办公室-收文
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Receipt对象", description="办公室-收文")
public class Receipt implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    @ApiModelProperty(value = "创建时间")
    private String creatimes;

    @ApiModelProperty(value = "来文单位")
    private String department;

    @ApiModelProperty(value = "来文时间")
    private Date times;

    @ApiModelProperty(value = "标题")
    private String titles;

    @ApiModelProperty(value = "来文字号")
    private String num;

    @ApiModelProperty(value = "办公室拟办意见")
    private String idea;

    @ApiModelProperty(value = "承办部门")
    private String undertakeDepartment;


    @ApiModelProperty(value = "分管长审核时间")
    private String fenDirectorTime;

    @ApiModelProperty(value = "分管长审核状态")
    private String  fenDirectorState;


}
