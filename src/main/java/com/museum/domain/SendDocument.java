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
 * 办公室公文管理-发文
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SendDocument对象", description="办公室公文管理-发文")
public class SendDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "发问号")
    private String document;

    private String document1;

    @ApiModelProperty(value = "缓急程度")
    private String degree;

    @ApiModelProperty(value = "发布时间")
    private String releaseTime;

    @ApiModelProperty(value = "简报")
    private String briefing;

    @ApiModelProperty(value = "第几期")
    private String stage;

    @ApiModelProperty(value = "主抄送")
    private String mainCopy;

    @ApiModelProperty(value = "副抄送")
    private String viceCopy;

    @ApiModelProperty(value = "拟稿部门")
    private String depoment;

    @ApiModelProperty(value = "拟稿人")
    private String name;

    @ApiModelProperty(value = "申请时间")
    private String apppltTime;

    @ApiModelProperty(value = "发布标题")
    private String title;

    @ApiModelProperty(value = "备注")
    private String remoke;

    @ApiModelProperty(value = "原始文件名")
    private String filename;

    @ApiModelProperty(value = "文件地址")
    private String fileaddress;

    @ApiModelProperty(value = "发起人")
    private Integer uid;

    @ApiModelProperty(value = "创建时间")
    private String createtimes;


}
