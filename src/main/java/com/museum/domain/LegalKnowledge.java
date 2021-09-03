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
 * @since 2021-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="LegalKnowledge对象", description="")
public class LegalKnowledge implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "1：法律、2：新政法规、3：规范性文件")
    private Integer lawType;

    @ApiModelProperty(value = "标题")
    private String lawTitle;

    @ApiModelProperty(value = "内容")
    private String lawContent;

    @ApiModelProperty(value = "文件地址")
    private String lawFilepath;

    @ApiModelProperty(value = "上传人id")
    private Integer uid;

    @ApiModelProperty(value = "上传时间")
    private String  createtimes;

    @ApiModelProperty(value = "文件名")
    private String filename;


}
