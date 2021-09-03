package com.museum.service;

import com.museum.domain.Position;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-08
 */
public interface IPositionService extends IService<Position> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Position>
     */
    IPage<Position> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param position 
     * @return int
     */
    int add(Position position);

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
     * @param position 
     * @return int
     */
    int updateData(Position position);

    /**
     * id查询数据
     *
     * @param id id
     * @return Position
     */
    Position findById(Long id);
}
