package com.museum.service;

import com.museum.domain.PointsMessage;
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
public interface IPointsMessageService extends IService<PointsMessage> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<PointsMessage>
     */
    IPage<PointsMessage> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param pointsMessage 
     * @return int
     */
    int add(PointsMessage pointsMessage);

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
     * @param pointsMessage 
     * @return int
     */
    int updateData(PointsMessage pointsMessage);

    /**
     * id查询数据
     *
     * @param id id
     * @return PointsMessage
     */
    PointsMessage findById(Long id);
}
