package com.museum.service;

import com.museum.domain.FinanceApplyPlanProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 财务用款计划申请流程 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
public interface IFinanceApplyPlanProcessService extends IService<FinanceApplyPlanProcess> {

    /**
     * 查询财务用款计划申请流程分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<FinanceApplyPlanProcess>
     */
    IPage<FinanceApplyPlanProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加财务用款计划申请流程
     *
     * @param financeApplyPlanProcess 财务用款计划申请流程
     * @return int
     */
    int add(FinanceApplyPlanProcess financeApplyPlanProcess);

    /**
     * 删除财务用款计划申请流程
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改财务用款计划申请流程
     *
     * @param financeApplyPlanProcess 财务用款计划申请流程
     * @return int
     */
    int updateData(FinanceApplyPlanProcess financeApplyPlanProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return FinanceApplyPlanProcess
     */
    FinanceApplyPlanProcess findById(Long id);
}
