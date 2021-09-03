package com.museum.service;

import com.museum.domain.MaintainProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 维护维修流程 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
public interface IMaintainProcessService extends IService<MaintainProcess> {

    /**
     * 查询维护维修流程分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<MaintainProcess>
     */
    IPage<MaintainProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加维护维修流程
     *
     * @param maintainProcess 维护维修流程
     * @return int
     */
    int add(MaintainProcess maintainProcess);

    /**
     * 删除维护维修流程
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改维护维修流程
     *
     * @param maintainProcess 维护维修流程
     * @return int
     */
    int updateData(MaintainProcess maintainProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return MaintainProcess
     */
    MaintainProcess findById(Long id);
}
