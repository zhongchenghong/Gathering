package com.museum.service;

import com.museum.domain.NotStructure;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-非结构化数据 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
public interface INotStructureService extends IService<NotStructure> {

    /**
     * 查询数据中心-非结构化数据分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<NotStructure>
     */
    IPage<NotStructure> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-非结构化数据
     *
     * @param notStructure 数据中心-非结构化数据
     * @return int
     */
    int add(NotStructure notStructure);

    /**
     * 删除数据中心-非结构化数据
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-非结构化数据
     *
     * @param notStructure 数据中心-非结构化数据
     * @return int
     */
    int updateData(NotStructure notStructure);

    /**
     * id查询数据
     *
     * @param id id
     * @return NotStructure
     */
    NotStructure findById(Long id);
}
