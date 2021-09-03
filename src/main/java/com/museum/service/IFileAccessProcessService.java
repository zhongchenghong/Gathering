package com.museum.service;

import com.museum.domain.FileAccessProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 资料采集制作流程表 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
public interface IFileAccessProcessService extends IService<FileAccessProcess> {

    /**
     * 查询资料采集制作流程表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<FileAccessProcess>
     */
    IPage<FileAccessProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加资料采集制作流程表
     *
     * @param fileAccessProcess 资料采集制作流程表
     * @return int
     */
    int add(FileAccessProcess fileAccessProcess);

    /**
     * 删除资料采集制作流程表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改资料采集制作流程表
     *
     * @param fileAccessProcess 资料采集制作流程表
     * @return int
     */
    int updateData(FileAccessProcess fileAccessProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return FileAccessProcess
     */
    FileAccessProcess findById(Long id);
}
