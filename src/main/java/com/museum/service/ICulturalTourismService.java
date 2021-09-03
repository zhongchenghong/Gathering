package com.museum.service;

import com.museum.domain.CulturalTourism;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-文旅数据上报 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
public interface ICulturalTourismService extends IService<CulturalTourism> {

    /**
     * 查询数据中心-文旅数据上报分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<CulturalTourism>
     */
    IPage<CulturalTourism> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-文旅数据上报
     *
     * @param culturalTourism 数据中心-文旅数据上报
     * @return int
     */
    int add(CulturalTourism culturalTourism);

    /**
     * 删除数据中心-文旅数据上报
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-文旅数据上报
     *
     * @param culturalTourism 数据中心-文旅数据上报
     * @return int
     */
    int updateData(CulturalTourism culturalTourism);

    /**
     * id查询数据
     *
     * @param id id
     * @return CulturalTourism
     */
    CulturalTourism findById(Long id);
}
