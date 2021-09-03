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
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Reception对象", description="")
public class Reception implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "来宾单位")
    private String company;

    @ApiModelProperty(value = "人数")
    private Integer sum;

    @ApiModelProperty(value = "联络人")
    private String contact;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "文物区0代表勾选，1代表未勾选")
    private Integer culturalRelic;

    @ApiModelProperty(value = "锦鲤区0代表勾选，1代表未勾选")
    private Integer jingli;

    @ApiModelProperty(value = "文化基地0代表勾选，1代表未勾选")
    private Integer culture;

    @ApiModelProperty(value = "座谈0代表勾选，1代表未勾选")
    private Integer lecture;

    @ApiModelProperty(value = "文物区时间")
    private Date culturalRelicTime;

    @ApiModelProperty(value = "锦鲤时间")
    private Date jingliTime;

    @ApiModelProperty(value = "文化基地时间")
    private Date cultureTime;

    @ApiModelProperty(value = "座谈时间")
    private Date lectureTime;

    @ApiModelProperty(value = "参与部门")
    private String department;

    @ApiModelProperty(value = "是否免票0免票，1不免票")
    private Integer freeTicket;

    @ApiModelProperty(value = "是否讲解：0讲解，1不讲解")
    private Integer explain;

    @ApiModelProperty(value = "是否陪同0：不，1：是")
    private Integer accompany;

    @ApiModelProperty(value = "是否停车0：不，1：是")
    private Integer parking;

    private Integer remarks;

    @ApiModelProperty(value = "领导id")
    private Integer leaderid;


}
