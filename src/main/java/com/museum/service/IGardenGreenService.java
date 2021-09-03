package com.museum.service;

import com.museum.domain.GardenGreen;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-12
 */
public interface IGardenGreenService extends IService<GardenGreen> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<GardenGreen>
     */
    IPage<GardenGreen> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param gardenGreen 
     * @return int
     */
    int add(GardenGreen gardenGreen);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param gardenGreen 
     * @return int
     */
    int updateData(GardenGreen gardenGreen);

    /**
     * id查询数据
     *
     * @param id id
     * @return GardenGreen
     */
    GardenGreen findById(Long id);

    /**
     * 绿化水体面积统计
     */

    List<GardenGreen> getGardenGreenCount(String type);
}
