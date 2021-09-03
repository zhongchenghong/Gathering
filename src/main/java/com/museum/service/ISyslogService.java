package com.museum.service;

import com.museum.domain.Syslog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-03
 */
public interface ISyslogService extends IService<Syslog> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Syslog>
     */
    IPage<Syslog> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param syslog 
     * @return int
     */
    int add(Syslog syslog);

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
     * @param syslog 
     * @return int
     */
    int updateData(Syslog syslog);

    /**
     * id查询数据
     *
     * @param id id
     * @return Syslog
     */
    Syslog findById(Long id);
}
