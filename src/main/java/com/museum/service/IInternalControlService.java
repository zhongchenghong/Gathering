package com.museum.service;

import com.museum.domain.InternalControl;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-09
 */
public interface IInternalControlService extends IService<InternalControl> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<InternalControl>
     */
    IPage<InternalControl> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param internalControl 
     * @return int
     */
    int add(InternalControl internalControl);

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
     * @param internalControl 
     * @return int
     */
    int updateData(InternalControl internalControl);

    /**
     * id查询数据
     *
     * @param id id
     * @return InternalControl
     */
    InternalControl findById(Long id);
}
