package com.museum.service;

import com.museum.domain.ComplaintForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 投诉处理表单 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-21
 */
public interface IComplaintFormService extends IService<ComplaintForm> {

    /**
     * 查询投诉处理表单分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ComplaintForm>
     */
    IPage<ComplaintForm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加投诉处理表单
     *
     * @param complaintForm 投诉处理表单
     * @return int
     */
    int add(ComplaintForm complaintForm);

    /**
     * 删除投诉处理表单
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改投诉处理表单
     *
     * @param complaintForm 投诉处理表单
     * @return int
     */
    int updateData(ComplaintForm complaintForm);

    /**
     * id查询数据
     *
     * @param id id
     * @return ComplaintForm
     */
    ComplaintForm findById(Long id);
}
