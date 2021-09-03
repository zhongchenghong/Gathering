package com.museum.service;

import com.museum.domain.GardenPlants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 园林景观-新增植物 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-12
 */
public interface IGardenPlantsService extends IService<GardenPlants> {

    /**
     * 查询园林景观-新增植物分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<GardenPlants>
     */
    IPage<GardenPlants> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加园林景观-新增植物
     *
     * @param gardenPlants 园林景观-新增植物
     * @return int
     */
    int add(GardenPlants gardenPlants);

    /**
     * 删除园林景观-新增植物
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改园林景观-新增植物
     *
     * @param gardenPlants 园林景观-新增植物
     * @return int
     */
    int updateData(GardenPlants gardenPlants);

    /**
     * id查询数据
     *
     * @param id id
     * @return GardenPlants
     */
    GardenPlants findById(Long id);
}
