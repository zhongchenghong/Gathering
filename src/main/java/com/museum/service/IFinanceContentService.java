package com.museum.service;

import com.museum.domain.FinanceContent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 */
public interface IFinanceContentService extends IService<FinanceContent> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<FinanceContent>
     */
    IPage<FinanceContent> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param financeContent 
     * @return int
     */
    int add(FinanceContent financeContent);

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
     * @param financeContent 
     * @return int
     */
    int updateData(FinanceContent financeContent);

    /**
     * id查询数据
     *
     * @param id id
     * @return FinanceContent
     */
    FinanceContent findById(Long id);
}
