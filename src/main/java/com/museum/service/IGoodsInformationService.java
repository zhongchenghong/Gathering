package com.museum.service;

import com.museum.domain.GoodsInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 信息中心录入物品名称 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
public interface IGoodsInformationService extends IService<GoodsInformation> {

    /**
     * 查询信息中心录入物品名称分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<GoodsInformation>
     */
    IPage<GoodsInformation> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加信息中心录入物品名称
     *
     * @param goodsInformation 信息中心录入物品名称
     * @return int
     */
    int add(GoodsInformation goodsInformation);

    /**
     * 删除信息中心录入物品名称
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改信息中心录入物品名称
     *
     * @param goodsInformation 信息中心录入物品名称
     * @return int
     */
    int updateData(GoodsInformation goodsInformation);

    /**
     * id查询数据
     *
     * @param id id
     * @return GoodsInformation
     */
    GoodsInformation findById(Long id);
}
