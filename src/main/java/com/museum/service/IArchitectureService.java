package com.museum.service;

import com.museum.domain.Architecture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-古建数据 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
public interface IArchitectureService extends IService<Architecture> {

    /**
     * 查询数据中心-古建数据分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Architecture>
     */
    IPage<Architecture> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-古建数据
     *
     * @param architecture 数据中心-古建数据
     * @return int
     */
    int add(Architecture architecture);

    /**
     * 删除数据中心-古建数据
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-古建数据
     *
     * @param architecture 数据中心-古建数据
     * @return int
     */
    int updateData(Architecture architecture);

    /**
     * id查询数据
     *
     * @param id id
     * @return Architecture
     */
    Architecture findById(Long id);
}
