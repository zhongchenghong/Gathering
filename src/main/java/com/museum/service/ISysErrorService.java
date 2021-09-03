package com.museum.service;

import com.museum.domain.SysError;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-07
 */
public interface ISysErrorService extends IService<SysError> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<SysError>
     */
    IPage<SysError> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param sysError 
     * @return int
     */
    int add(SysError sysError);

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
     * @param sysError 
     * @return int
     */
    int updateData(SysError sysError);

    /**
     * id查询数据
     *
     * @param id id
     * @return SysError
     */
    SysError findById(Long id);
}
