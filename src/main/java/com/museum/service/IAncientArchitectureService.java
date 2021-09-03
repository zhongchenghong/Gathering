package com.museum.service;

import com.museum.domain.AncientArchitecture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-古建数据 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
public interface IAncientArchitectureService extends IService<AncientArchitecture> {

    /**
     * 查询数据中心-古建数据分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<AncientArchitecture>
     */
    IPage<AncientArchitecture> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-古建数据
     *
     * @param ancientArchitecture 数据中心-古建数据
     * @return int
     */
    int add(AncientArchitecture ancientArchitecture);

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
     * @param ancientArchitecture 数据中心-古建数据
     * @return int
     */
    int updateData(AncientArchitecture ancientArchitecture);

    /**
     * id查询数据
     *
     * @param id id
     * @return AncientArchitecture
     */
    AncientArchitecture findById(Long id);
}
