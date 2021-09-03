package com.museum.service;

import com.museum.domain.FinanceApplyPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 用款计划申请 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 */
public interface IFinanceApplyPlanService extends IService<FinanceApplyPlan> {

    /**
     * 查询用款计划申请分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<FinanceApplyPlan>
     */
    IPage<FinanceApplyPlan> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加用款计划申请
     *
     * @param financeApplyPlan 用款计划申请
     * @return int
     */
    int add(FinanceApplyPlan financeApplyPlan);

    /**
     * 删除用款计划申请
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改用款计划申请
     *
     * @param financeApplyPlan 用款计划申请
     * @return int
     */
    int updateData(FinanceApplyPlan financeApplyPlan);

    /**
     * id查询数据
     *
     * @param id id
     * @return FinanceApplyPlan
     */
    FinanceApplyPlan findById(Long id);
}
