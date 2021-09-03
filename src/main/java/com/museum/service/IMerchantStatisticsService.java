package com.museum.service;

import com.museum.domain.JLProportion;
import com.museum.domain.JlCount;
import com.museum.domain.MerchantStatistics;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 锦里商户统计、商户列表 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
public interface IMerchantStatisticsService extends IService<MerchantStatistics> {

    /**
     * 查询锦里商户统计、商户列表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<MerchantStatistics>
     */
    IPage<MerchantStatistics> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加锦里商户统计、商户列表
     *
     * @param merchantStatistics 锦里商户统计、商户列表
     * @return int
     */
    int add(MerchantStatistics merchantStatistics);

    /**
     * 删除锦里商户统计、商户列表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改锦里商户统计、商户列表
     *
     * @param merchantStatistics 锦里商户统计、商户列表
     * @return int
     */
    int updateData(MerchantStatistics merchantStatistics);

    /**
     * id查询数据
     *
     * @param id id
     * @return MerchantStatistics
     */
    MerchantStatistics findById(Long id);

    /**
     * 锦里商户统计
     * @return
     */
    List<JlCount> bycount();

    /**
     *商户（分类别）总交易金额占比
     */
    List<JLProportion> byTypesCount();
}
