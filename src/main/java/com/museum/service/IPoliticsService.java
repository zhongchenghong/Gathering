package com.museum.service;

import com.museum.domain.Politics;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-08
 */
public interface IPoliticsService extends IService<Politics> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Politics>
     */
    IPage<Politics> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param politics 
     * @return int
     */
    int add(Politics politics);

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
     * @param politics 
     * @return int
     */
    int updateData(Politics politics);

    /**
     * id查询数据
     *
     * @param id id
     * @return Politics
     */
    Politics findById(Long id);
}
