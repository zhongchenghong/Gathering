package com.museum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 藏品管理系统（分类统计）
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CollectionClassification对象", description="藏品管理系统（分类统计）")
public class CollectionClassification implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "入藏年度")
    private Integer collectionYear;

    @ApiModelProperty(value = "藏品传统总数")
    private Integer collectionTraditionSum;

    @ApiModelProperty(value = "藏品实际总数")
    private Integer collectionActualSum;

    @ApiModelProperty(value = "玉器(传统)")
    private Integer  jadewareTradition;

    @ApiModelProperty(value = "玉器(实际)")
    private Integer  jadewareActual;

    @ApiModelProperty(value = "陶器(传统)")
    private Integer potteryTradition;

    @ApiModelProperty(value = "陶器(实际)")
    private Integer potteryActual;

    @ApiModelProperty(value = "瓷器(传统)")
    private Integer porcelainTradition;

    @ApiModelProperty(value = "瓷器(实际)")
    private Integer porcelainActual;

    @ApiModelProperty(value = "铜器(传统)")
    private Integer bronzeWareTradition;

    @ApiModelProperty(value = "铜器(实际)")
    private Integer bronzeWareActual;

    @ApiModelProperty(value = "银器(传统)")
    private Integer silverTradition;

    @ApiModelProperty(value = "银器(实际)")
    private Integer silverActual;

    @ApiModelProperty(value = "铁器(传统)")
    private Integer ironTradition;

    @ApiModelProperty(value = "铁器(传统)")
    private Integer ironActual;

    @ApiModelProperty(value = "漆器(传统)")
    private Integer lacquerWareTradition;

    @ApiModelProperty(value = "漆器(实际)")
    private Integer lacquerWareActual;

    @ApiModelProperty(value = "塑像(传统)")
    private Integer plasticizerTradition;

    @ApiModelProperty(value = "塑像(实际)")
    private Integer plasticizerActual;

    @ApiModelProperty(value = "石器(传统)")
    private Integer stoneArtifactTradition;

    @ApiModelProperty(value = "石器(实际)")
    private Integer stoneArtifactActual;

    @ApiModelProperty(value = "书法(传统)")
    private Integer calligraphyTradition;

    @ApiModelProperty(value = "书法(实际)")
    private Integer calligraphyActual;

    @ApiModelProperty(value = "文具(传统)")
    private Integer stationeryTradition;

    @ApiModelProperty(value = "文具(实际)")
    private Integer stationeryActual;

    @ApiModelProperty(value = "甲骨(传统)")
    private Integer oracleBoneTradition;

    @ApiModelProperty(value = "甲骨(实际)")
    private Integer oracleBoneActual;

    @ApiModelProperty(value = "玺印符牌(传统)")
    private Integer imperialJadeSealTradition;

    @ApiModelProperty(value = "玺印符牌(实际)")
    private Integer imperialJadeSealActual;

    @ApiModelProperty(value = "钱币(传统)")
    private Integer moneyTradition;

    @ApiModelProperty(value = "钱币(实际)")
    private Integer moneyActual;

    @ApiModelProperty(value = "牙骨角器(传统)")
    private Integer dentalBoneTradition;

    @ApiModelProperty(value = "牙骨角器(实际)")
    private Integer dentalBoneActual;

    @ApiModelProperty(value = "竹木器(传统)")
    private Integer bambooTradition;

    @ApiModelProperty(value = "竹木器(实际)")
    private Integer bambooActual;

    @ApiModelProperty(value = "家具(传统)")
    private Integer furnitureTradition;

    @ApiModelProperty(value = "家具(实际)")
    private Integer furnitureActual;

    @ApiModelProperty(value = "珐琅器(传统)")
    private Integer enamelTradition;

    @ApiModelProperty(value = "珐琅器(实际)")
    private Integer enamelActual;

    @ApiModelProperty(value = "织绣(传统)")
    private Integer embroideryTradition;

    @ApiModelProperty(value = "织绣(实际)")
    private Integer embroideryActual;

    @ApiModelProperty(value = "古籍(传统)")
    private Integer ancientWorksTradition;

    @ApiModelProperty(value = "古籍(实际)")
    private Integer ancientWorksActual;

    @ApiModelProperty(value = "拓片(传统)")
    private Integer rubbingTradition;

    @ApiModelProperty(value = "拓片(实际)")
    private Integer rubbingActual;

    @ApiModelProperty(value = "武器(传统)")
    private Integer armsTradition;

    @ApiModelProperty(value = "武器(实际)")
    private Integer armsActual;

    @ApiModelProperty(value = "邮品(传统)")
    private Integer stampProductsTradition;

    @ApiModelProperty(value = "邮品(实际)")
    private Integer stampProductsActual;

    @ApiModelProperty(value = "文件、宣传品(传统)")
    private Integer fileTradition;

    @ApiModelProperty(value = "文件、宣传品(实际)")
    private Integer fileActual;

    @ApiModelProperty(value = "档案文书(传统)")
    private Integer archivesTradition;

    @ApiModelProperty(value = "档案文书(实际)")
    private Integer archivesActual;

    @ApiModelProperty(value = "名人遗物(传统)")
    private Integer relicTradition;

    @ApiModelProperty(value = "名人遗物(实际)")
    private Integer relicActual;

    @ApiModelProperty(value = "玻璃器(传统)")
    private Integer glassTradition;

    @ApiModelProperty(value = "玻璃器(实际)")
    private Integer glassActual;

    @ApiModelProperty(value = "乐器、法器(传统)")
    @TableField("musical_Instruments_tradition")
    private Integer musicalInstrumentsTradition;

    @ApiModelProperty(value = "乐器、法器(实际)")
    @TableField("musical_Instruments_actual")
    private Integer musicalInstrumentsActual;

    @ApiModelProperty(value = "皮革(传统)")
    private Integer leatherwearTradition;

    @ApiModelProperty(value = "皮革(实际)")
    private Integer leatherwearActual;

    @ApiModelProperty(value = "音像制品(传统)")
    private Integer videoTradition;

    @ApiModelProperty(value = "音像制品(实际)")
    private Integer videoActual;

    @ApiModelProperty(value = "票据(传统)")
    private Integer billTraffic;

    @ApiModelProperty(value = "票据(实际)")
    private Integer billActual;

    @ApiModelProperty(value = "交通、运输工具(传统)")
    private Integer trafficTraffic;

    @ApiModelProperty(value = "交通、运输工具(实际)")
    private Integer trafficActual;

    @ApiModelProperty(value = "度量衡器(传统)")
    private Integer measureTraffic;

    @ApiModelProperty(value = "度量衡器(实际)")
    private Integer measureActual;

    @ApiModelProperty(value = "标本、化石(传统)")
    private Integer specimenTraffic;

    @ApiModelProperty(value = "标本、化石(实际)")
    private Integer specimenActual;

    @ApiModelProperty(value = "其它(传统)")
    private Integer otherTraffic;

    @ApiModelProperty(value = "其它(实际)")
    private Integer otherActual;

    @ApiModelProperty(value = "石刻(传统)")
    private Integer stoneCarvingTraffic;

    @ApiModelProperty(value = "石刻(实际)")
    private Integer stoneCarvingActual;

    @ApiModelProperty(value = "砖瓦(传统)")
    private Integer brickTraffic;

    @ApiModelProperty(value = "砖瓦(实际)")
    private Integer brickActual;

    @ApiModelProperty(value = "绘画(传统)")
    private Integer paintingTraffic;

    @ApiModelProperty(value = "绘画(实际)")
    private Integer paintingActual;

    @ApiModelProperty(value = "拓片(传统)")
    private Integer rubbingTradition1;

    @ApiModelProperty(value = "拓片(实际)")
    private Integer rubbingActual1;

    private Integer uid;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;


}
