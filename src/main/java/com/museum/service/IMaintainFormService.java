package com.museum.service;

import com.museum.domain.MaintainForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 软硬件维护维修申请单 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
public interface IMaintainFormService extends IService<MaintainForm> {

    /**
     * 查询软硬件维护维修申请单分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<MaintainForm>
     */
    IPage<MaintainForm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加软硬件维护维修申请单
     *
     * @param maintainForm 软硬件维护维修申请单
     * @return int
     */
    int add(MaintainForm maintainForm);

    /**
     * 删除软硬件维护维修申请单
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改软硬件维护维修申请单
     *
     * @param maintainForm 软硬件维护维修申请单
     * @return int
     */
    int updateData(MaintainForm maintainForm);

    /**
     * id查询数据
     *
     * @param id id
     * @return MaintainForm
     */
    MaintainForm findById(Long id);
}
