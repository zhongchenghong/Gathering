package com.museum.service;

import com.museum.domain.VisitsName;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-15
 */
public interface IVisitsNameService extends IService<VisitsName> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<VisitsName>
     */
    IPage<VisitsName> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param visitsName 
     * @return int
     */
    int add(VisitsName visitsName);

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
     * @param visitsName 
     * @return int
     */
    int updateData(VisitsName visitsName);

    /**
     * id查询数据
     *
     * @param id id
     * @return VisitsName
     */
    VisitsName findById(Long id);
}
