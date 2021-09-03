package com.museum.service;

import com.museum.domain.Industry;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 文创产业部产业添加 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
public interface IIndustryService extends IService<Industry> {

    /**
     * 查询文创产业部产业添加分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Industry>
     */
    IPage<Industry> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加文创产业部产业添加
     *
     * @param industry 文创产业部产业添加
     * @return int
     */
    int add(Industry industry);

    /**
     * 删除文创产业部产业添加
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改文创产业部产业添加
     *
     * @param industry 文创产业部产业添加
     * @return int
     */
    int updateData(Industry industry);

    /**
     * id查询数据
     *
     * @param id id
     * @return Industry
     */
    Industry findById(Long id);
}
