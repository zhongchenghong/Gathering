package com.museum.service;

import com.museum.domain.FinancialSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 财务部科目 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 */
public interface IFinancialSubjectService extends IService<FinancialSubject> {

    /**
     * 查询财务部科目分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<FinancialSubject>
     */
    IPage<FinancialSubject> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加财务部科目
     *
     * @param financialSubject 财务部科目
     * @return int
     */
    int add(FinancialSubject financialSubject);

    /**
     * 删除财务部科目
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改财务部科目
     *
     * @param financialSubject 财务部科目
     * @return int
     */
    int updateData(FinancialSubject financialSubject);

    /**
     * id查询数据
     *
     * @param id id
     * @return FinancialSubject
     */
    FinancialSubject findById(Long id);
}
