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
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 
 * </p>
 *
 * @author lsj
 * @since 2021-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Resources对象", description="")
public class Resources implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "文件地址")
    private String readdress;

    @ApiModelProperty(value = "文件类型：1为图片、2为视频、3文件、4、文字")
    private Integer types;

    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "时间")
    private Date times;

    @ApiModelProperty(value = "原始文件名")
    private String filename;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "描述")
    private String describes;

    @ApiModelProperty(value = "上传地址")
    private String pathaddress;


    @ApiModelProperty(value = "功能id")
    private int functionId;

    @ApiModelProperty(value = "是否共享")
    private int share;








}
