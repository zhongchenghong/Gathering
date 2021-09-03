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
 * 泰合信息安全运营中心系统
 * </p>
 *
 * @author lsj
 * @since 2021-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SafeOperation对象", description="泰合信息安全运营中心系统")
public class SafeOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "事件id")
    private String lid;

    @ApiModelProperty(value = "归并数目")
    private String imergecount;

    @ApiModelProperty(value = "事件名称")
    private String ceventname;

    @ApiModelProperty(value = "解析内容")
    private String ceventdigest;

    @ApiModelProperty(value = "事件分类")
    private String ceventtype;

    @ApiModelProperty(value = "采集类型")
    private String icollecttype;

    @ApiModelProperty(value = "等级")
    private String ieventlevel;

    private String iprotocol;

    @ApiModelProperty(value = "应用协议")
    private String iappprotocol;

    @ApiModelProperty(value = "发送者地址")
    private String csrcname;

    @ApiModelProperty(value = "源MAC地址")
    private String csrcmac;

    @ApiModelProperty(value = "源地址")
    private String csrcip;

    @ApiModelProperty(value = "源转换IP地址")
    private String csrctip;

    @ApiModelProperty(value = "源端口")
    private String isrcport;

    @ApiModelProperty(value = "源掩码")
    private String isrctport;

    @ApiModelProperty(value = "接收地址_1")
    private String cdstname;

    @ApiModelProperty(value = "目的MAC地址")
    private String cdstmac;

    @ApiModelProperty(value = "目的地址")
    private String cdstip;

    @ApiModelProperty(value = "目的转换IP地址")
    private String cdsttip;

    @ApiModelProperty(value = "目的端口")
    private String idstport;

    @ApiModelProperty(value = "目的掩码")
    private String idsttport;

    @ApiModelProperty(value = "用户名称")
    private String cusername;

    @ApiModelProperty(value = "程序名称")
    private String cprogram;

    @ApiModelProperty(value = "操作")
    private String coperation;

    @ApiModelProperty(value = "域名")
    private String cobject;

    @ApiModelProperty(value = "结果")
    private String iresult;

    @ApiModelProperty(value = "响应")
    private String ireponse;

    @ApiModelProperty(value = "设备名称")
    private String cdevname;

    @ApiModelProperty(value = "源设备类型")
    private String cdevtype;

    @ApiModelProperty(value = "设备地址")
    private String cdevip;

    @ApiModelProperty(value = "发生时间")
    private Date loccurtime;

    @ApiModelProperty(value = "接受时间")
    private Date lrecepttime;

    @ApiModelProperty(value = "采集器IP地址")
    private String ccollectorip;

    @ApiModelProperty(value = "发送流量(Byte)")
    private String lsend;

    @ApiModelProperty(value = "接收流量(Byte)")
    private String lreceive;

    @ApiModelProperty(value = "持续时间(毫秒)")
    private String lduration;

    @ApiModelProperty(value = "SRC_AS")
    private String dmonitorvalue;

    @ApiModelProperty(value = "原始等级")
    private String corilevel;

    @ApiModelProperty(value = "原始类型")
    private String coritype;

    @ApiModelProperty(value = "日志类型")
    private String istandby1;

    @ApiModelProperty(value = "业务场景")
    private String istandby2;

    @ApiModelProperty(value = "发送包数")
    private String lstandby1;

    @ApiModelProperty(value = "接收包数")
    private String lstandby2;

    @ApiModelProperty(value = "发/收(字节)比率")
    private String dstandby1;

    @ApiModelProperty(value = "发/收(数据包)比率")
    private String dstandby2;

    @ApiModelProperty(value = "厂商")
    private String cstandby1;

    @ApiModelProperty(value = "产品")
    private String cstandby2;

    @ApiModelProperty(value = "文件名")
    private String cstandby3;

    @ApiModelProperty(value = "备用字符串4")
    private String cstandby4;

    @ApiModelProperty(value = "源区域")
    private String cstandby5;

    @ApiModelProperty(value = "目的区域")
    private String cstandby6;

    @ApiModelProperty(value = "TCPFlags")
    private String istandby3;

    @ApiModelProperty(value = "Tops")
    private String istandby4;

    @ApiModelProperty(value = "子协议")
    private String istandby5;

    @ApiModelProperty(value = "DST_AS")
    private String istandby6;

    @ApiModelProperty(value = "Input")
    private String lstandby3;

    @ApiModelProperty(value = "Output")
    private String lstandby4;

    @ApiModelProperty(value = "总包数")
    private String lstandby5;

    @ApiModelProperty(value = "功能码")
    private String lstandby6;

    @ApiModelProperty(value = "目的设备类型")
    private String cstandby7;

    @ApiModelProperty(value = "下一跳")
    private String cstandby8;

    @ApiModelProperty(value = "接收地址_2")
    private String cstandby9;

    @ApiModelProperty(value = "Title")
    private String cstandby10;

    @ApiModelProperty(value = "抄送地址_1")
    private String cstandby11;

    @ApiModelProperty(value = "抄送地址_2")
    private String cstandby12;

    @ApiModelProperty(value = "请求内容")
    private String crequestmsg;

    @ApiModelProperty(value = "原始消息")
    private String ceventmsg;


}
