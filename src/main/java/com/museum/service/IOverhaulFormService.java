package com.museum.service;

import com.museum.domain.OverhaulForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 水电维修维护表单 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
public interface IOverhaulFormService extends IService<OverhaulForm> {

    /**
     * 查询水电维修维护表单分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<OverhaulForm>
     */
    IPage<OverhaulForm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加水电维修维护表单
     *
     * @param overhaulForm 水电维修维护表单
     * @return int
     */
    int add(OverhaulForm overhaulForm);

    /**
     * 删除水电维修维护表单
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改水电维修维护表单
     *
     * @param overhaulForm 水电维修维护表单
     * @return int
     */
    int updateData(OverhaulForm overhaulForm);

    /**
     * id查询数据
     *
     * @param id id
     * @return OverhaulForm
     */
    OverhaulForm findById(Long id);
}
