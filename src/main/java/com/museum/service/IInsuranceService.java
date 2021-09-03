package com.museum.service;

import com.museum.domain.Insurance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 办公室车辆保险 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
public interface IInsuranceService extends IService<Insurance> {

    /**
     * 查询办公室车辆保险分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Insurance>
     */
    IPage<Insurance> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加办公室车辆保险
     *
     * @param insurance 办公室车辆保险
     * @return int
     */
    int add(Insurance insurance);

    /**
     * 删除办公室车辆保险
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改办公室车辆保险
     *
     * @param insurance 办公室车辆保险
     * @return int
     */
    int updateData(Insurance insurance);

    /**
     * id查询数据
     *
     * @param id id
     * @return Insurance
     */
    Insurance findById(Long id);
}
