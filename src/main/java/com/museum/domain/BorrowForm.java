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
 * @since 2021-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BorrowForm对象", description="")
public class BorrowForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    @ApiModelProperty(value = "借阅时间")
    private Date borrowTime;

    @ApiModelProperty(value = "借阅部门")
    private String borrowDepartment;

    @ApiModelProperty(value = "借阅人")
    private String borrowName;

    @ApiModelProperty(value = "档案名称")
    private String borrowTitle;

    @ApiModelProperty(value = "借阅数量")
    private Integer borrowSum;

    @ApiModelProperty(value = "归还时间")
    private Date returnTime;

    @ApiModelProperty(value = "用途")
    private String purpose;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "创建时间")
    private String createtime;


}
