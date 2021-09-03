package com.museum.service;

import com.museum.domain.Remains;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-遗存调查数据 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
public interface IRemainsService extends IService<Remains> {

    /**
     * 查询数据中心-遗存调查数据分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Remains>
     */
    IPage<Remains> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-遗存调查数据
     *
     * @param remains 数据中心-遗存调查数据
     * @return int
     */
    int add(Remains remains);

    /**
     * 删除数据中心-遗存调查数据
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-遗存调查数据
     *
     * @param remains 数据中心-遗存调查数据
     * @return int
     */
    int updateData(Remains remains);

    /**
     * id查询数据
     *
     * @param id id
     * @return Remains
     */
    Remains findById(Long id);
}
