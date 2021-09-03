package com.museum.service;

import com.museum.domain.PublicSentiment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-舆情 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
public interface IPublicSentimentService extends IService<PublicSentiment> {

    /**
     * 查询数据中心-舆情分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<PublicSentiment>
     */
    IPage<PublicSentiment> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-舆情
     *
     * @param publicSentiment 数据中心-舆情
     * @return int
     */
    int add(PublicSentiment publicSentiment);

    /**
     * 删除数据中心-舆情
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-舆情
     *
     * @param publicSentiment 数据中心-舆情
     * @return int
     */
    int updateData(PublicSentiment publicSentiment);

    /**
     * id查询数据
     *
     * @param id id
     * @return PublicSentiment
     */
    PublicSentiment findById(Long id);
}
