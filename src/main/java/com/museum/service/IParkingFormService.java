package com.museum.service;

import com.museum.domain.ParkingForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 临时停车表单 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
public interface IParkingFormService extends IService<ParkingForm> {

    /**
     * 查询临时停车表单分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ParkingForm>
     */
    IPage<ParkingForm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加临时停车表单
     *
     * @param parkingForm 临时停车表单
     * @return int
     */
    int add(ParkingForm parkingForm);

    /**
     * 删除临时停车表单
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改临时停车表单
     *
     * @param parkingForm 临时停车表单
     * @return int
     */
    int updateData(ParkingForm parkingForm);

    /**
     * id查询数据
     *
     * @param id id
     * @return ParkingForm
     */
    ParkingForm findById(Long id);
}
