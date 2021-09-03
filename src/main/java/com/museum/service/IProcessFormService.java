package com.museum.service;

import com.museum.domain.ProcessForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-28
 */
public interface IProcessFormService extends IService<ProcessForm> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ProcessForm>
     */
    IPage<ProcessForm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param processForm 
     * @return int
     */
    int add(ProcessForm processForm);

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
     * @param processForm 
     * @return int
     */
    int updateData(ProcessForm processForm);

    /**
     * id查询数据
     *
     * @param id id
     * @return ProcessForm
     */
    ProcessForm findById(Long id);
}
