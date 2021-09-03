package com.museum.service;

import com.museum.domain.Visits;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-15
 */
public interface IVisitsService extends IService<Visits> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Visits>
     */
    IPage<Visits> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param visits 
     * @return int
     */
    int add(Visits visits);

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
     * @param visits 
     * @return int
     */
    int updateData(Visits visits);

    /**
     * id查询数据
     *
     * @param id id
     * @return Visits
     */
    Visits findById(Long id);
}
