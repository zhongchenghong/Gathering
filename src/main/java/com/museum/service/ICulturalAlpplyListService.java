package com.museum.service;

import com.museum.domain.CulturalAlpplyList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 子类物品列表 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
public interface ICulturalAlpplyListService extends IService<CulturalAlpplyList> {

    /**
     * 查询子类物品列表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<CulturalAlpplyList>
     */
    IPage<CulturalAlpplyList> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加子类物品列表
     *
     * @param culturalAlpplyList 子类物品列表
     * @return int
     */
    int add(CulturalAlpplyList culturalAlpplyList);

    /**
     * 删除子类物品列表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改子类物品列表
     *
     * @param culturalAlpplyList 子类物品列表
     * @return int
     */
    int updateData(CulturalAlpplyList culturalAlpplyList);

    /**
     * id查询数据
     *
     * @param id id
     * @return CulturalAlpplyList
     */
    CulturalAlpplyList findById(Long id);
}
