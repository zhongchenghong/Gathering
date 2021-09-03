package com.museum.service;

import com.museum.domain.ArchiveBydepartment;
import com.museum.domain.Archives;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-15
 */
public interface IArchivesService extends IService<Archives> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Archives>
     */
    IPage<Archives> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param archives 
     * @return int
     */
    int add(Archives archives);

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
     * @param archives 
     * @return int
     */
    int updateData(Archives archives);

    /**
     * id查询数据
     *
     * @param id id
     * @return Archives
     */
    Archives findById(Long id);

    /**
     * 获取部门档案统计
     * @return
     */
    List<ArchiveBydepartment> selectArchiveBydepartment();

    /**
     * 部门档案占比
     * @param createTime
     * @return
     */
    List<ArchiveBydepartment> selectarchivesTypeId(String createTime);
}
