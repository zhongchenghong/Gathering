package com.museum.service;

import com.museum.domain.SealProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 用章流程 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-26
 */
public interface ISealProcessService extends IService<SealProcess> {

    /**
     * 查询用章流程分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<SealProcess>
     */
    IPage<SealProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加用章流程
     *
     * @param sealProcess 用章流程
     * @return int
     */
    int add(SealProcess sealProcess);

    /**
     * 删除用章流程
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改用章流程
     *
     * @param sealProcess 用章流程
     * @return int
     */
    int updateData(SealProcess sealProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return SealProcess
     */
    SealProcess findById(Long id);
}
