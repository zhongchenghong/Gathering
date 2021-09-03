package com.museum.service;

import com.museum.domain.OverhaulProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 水电维修维护申请流程 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
public interface IOverhaulProcessService extends IService<OverhaulProcess> {

    /**
     * 查询水电维修维护申请流程分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<OverhaulProcess>
     */
    IPage<OverhaulProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加水电维修维护申请流程
     *
     * @param overhaulProcess 水电维修维护申请流程
     * @return int
     */
    int add(OverhaulProcess overhaulProcess);

    /**
     * 删除水电维修维护申请流程
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改水电维修维护申请流程
     *
     * @param overhaulProcess 水电维修维护申请流程
     * @return int
     */
    int updateData(OverhaulProcess overhaulProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return OverhaulProcess
     */
    OverhaulProcess findById(Long id);
}
