package com.museum.service;

import com.museum.domain.NotMoveRelic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-不可移动文物 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
public interface INotMoveRelicService extends IService<NotMoveRelic> {

    /**
     * 查询数据中心-不可移动文物分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<NotMoveRelic>
     */
    IPage<NotMoveRelic> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-不可移动文物
     *
     * @param notMoveRelic 数据中心-不可移动文物
     * @return int
     */
    int add(NotMoveRelic notMoveRelic);

    /**
     * 删除数据中心-不可移动文物
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-不可移动文物
     *
     * @param notMoveRelic 数据中心-不可移动文物
     * @return int
     */
    int updateData(NotMoveRelic notMoveRelic);

    /**
     * id查询数据
     *
     * @param id id
     * @return NotMoveRelic
     */
    NotMoveRelic findById(Long id);
}
