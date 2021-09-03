package com.museum.service;

import com.museum.domain.Releases;
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
public interface IReleasesService extends IService<Releases> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Releases>
     */
    IPage<Releases> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param releases 
     * @return int
     */
    int add(Releases releases);

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
     * @param releases 
     * @return int
     */
    int updateData(Releases releases);

    /**
     * id查询数据
     *
     * @param id id
     * @return Releases
     */
    Releases findById(Long id);
}
