package com.museum.service;

import com.museum.domain.SealForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-21
 */
public interface ISealFormService extends IService<SealForm> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<SealForm>
     */
    IPage<SealForm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param sealForm 
     * @return int
     */
    int add(SealForm sealForm);

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
     * @param sealForm 
     * @return int
     */
    int updateData(SealForm sealForm);

    /**
     * id查询数据
     *
     * @param id id
     * @return SealForm
     */
    SealForm findById(Long id);
}
