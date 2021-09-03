package com.museum.service;

import com.museum.domain.MapPoints;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-24
 */
public interface IMapPointsService extends IService<MapPoints> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<MapPoints>
     */
    IPage<MapPoints> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param mapPoints 
     * @return int
     */
    int add(MapPoints mapPoints);

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
     * @param mapPoints 
     * @return int
     */
    int updateData(MapPoints mapPoints);

    /**
     * id查询数据
     *
     * @param id id
     * @return MapPoints
     */
    MapPoints findById(Long id);
}
