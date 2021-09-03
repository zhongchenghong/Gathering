package com.museum.service;

import com.museum.domain.CulturalList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 物品列表 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
public interface ICulturalListService extends IService<CulturalList> {

    /**
     * 查询物品列表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<CulturalList>
     */
    IPage<CulturalList> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加物品列表
     *
     * @param culturalList 物品列表
     * @return int
     */
    int add(CulturalList culturalList);

    /**
     * 删除物品列表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改物品列表
     *
     * @param culturalList 物品列表
     * @return int
     */
    int updateData(CulturalList culturalList);

    /**
     * id查询数据
     *
     * @param id id
     * @return CulturalList
     */
    CulturalList findById(Long id);
}
