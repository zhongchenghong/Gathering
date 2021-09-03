package com.museum.service;

import com.museum.domain.JinliActivityEntry;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 锦里公司活动录入 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
public interface IJinliActivityEntryService extends IService<JinliActivityEntry> {

    /**
     * 查询锦里公司活动录入分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<JinliActivityEntry>
     */
    IPage<JinliActivityEntry> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加锦里公司活动录入
     *
     * @param jinliActivityEntry 锦里公司活动录入
     * @return int
     */
    int add(JinliActivityEntry jinliActivityEntry);

    /**
     * 删除锦里公司活动录入
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改锦里公司活动录入
     *
     * @param jinliActivityEntry 锦里公司活动录入
     * @return int
     */
    int updateData(JinliActivityEntry jinliActivityEntry);

    /**
     * id查询数据
     *
     * @param id id
     * @return JinliActivityEntry
     */
    JinliActivityEntry findById(Long id);
}
