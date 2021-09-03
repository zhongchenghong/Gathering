package com.museum.service;

import com.museum.domain.Rules;
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
public interface IRulesService extends IService<Rules> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Rules>
     */
    IPage<Rules> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param rules 
     * @return int
     */
    int add(Rules rules);

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
     * @param rules 
     * @return int
     */
    int updateData(Rules rules);

    /**
     * id查询数据
     *
     * @param id id
     * @return Rules
     */
    Rules findById(Long id);
}
