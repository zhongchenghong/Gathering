package com.museum.service;

import com.museum.domain.ArchivesTotal;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 档案统计 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-27
 */
public interface IArchivesTotalService extends IService<ArchivesTotal> {

    /**
     * 查询档案统计分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ArchivesTotal>
     */
    IPage<ArchivesTotal> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加档案统计
     *
     * @param archivesTotal 档案统计
     * @return int
     */
    int add(ArchivesTotal archivesTotal);

    /**
     * 删除档案统计
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改档案统计
     *
     * @param archivesTotal 档案统计
     * @return int
     */
    int updateData(ArchivesTotal archivesTotal);

    /**
     * id查询数据
     *
     * @param id id
     * @return ArchivesTotal
     */
    ArchivesTotal findById(Long id);
}
