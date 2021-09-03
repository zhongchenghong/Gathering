package com.museum.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 锦里培训登记
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TrainRegister对象", description="锦里培训登记")
public class TrainRegister implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer uid;

    @ApiModelProperty(value = "培训日期")
    @TableField("trainTime")
    private String trainTime;

    @ApiModelProperty(value = "培训地点")
    private String trainAddress;

    @ApiModelProperty(value = "培训部门及人员")
    private String trainDepartmentPeople;

    @ApiModelProperty(value = "培训内容")
    private String trainContent;

    @ApiModelProperty(value = "上传地址")
    private String fileaddress;

    @ApiModelProperty(value = "文件原始名")
    private String filename;

    @ApiModelProperty(value = "创建时间")
    private String createtime;


}
