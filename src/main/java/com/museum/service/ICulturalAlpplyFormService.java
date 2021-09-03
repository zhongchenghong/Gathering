package com.museum.service;

import com.museum.domain.CulturalAlpplyForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 文创产品申请单 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
public interface ICulturalAlpplyFormService extends IService<CulturalAlpplyForm> {

    /**
     * 查询文创产品申请单分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<CulturalAlpplyForm>
     */
    IPage<CulturalAlpplyForm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加文创产品申请单
     *
     * @param culturalAlpplyForm 文创产品申请单
     * @return int
     */
    int add(CulturalAlpplyForm culturalAlpplyForm);

    /**
     * 删除文创产品申请单
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改文创产品申请单
     *
     * @param culturalAlpplyForm 文创产品申请单
     * @return int
     */
    int updateData(CulturalAlpplyForm culturalAlpplyForm);

    /**
     * id查询数据
     *
     * @param id id
     * @return CulturalAlpplyForm
     */
    CulturalAlpplyForm findById(Long id);
}
