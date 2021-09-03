package com.museum.domain;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 档案统计
 * </p>
 *
 * @author lsj
 * @since 2021-07-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ArchivesTotal对象", description="档案统计")
public class ArchivesTotal implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "查阅总数")
    private Integer consulttotal;

    @ApiModelProperty(value = "借阅总数")
    private Integer borrowingtotal;

    @ApiModelProperty(value = "档案总数")
    private Integer total;

    @ApiModelProperty(value = "当前借阅数")
    private Integer current;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;


}
