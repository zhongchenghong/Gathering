package com.museum.service;

import com.museum.domain.ParkingProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 临时停车申请流程 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
public interface IParkingProcessService extends IService<ParkingProcess> {

    /**
     * 查询临时停车申请流程分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ParkingProcess>
     */
    IPage<ParkingProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加临时停车申请流程
     *
     * @param parkingProcess 临时停车申请流程
     * @return int
     */
    int add(ParkingProcess parkingProcess);

    /**
     * 删除临时停车申请流程
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改临时停车申请流程
     *
     * @param parkingProcess 临时停车申请流程
     * @return int
     */
    int updateData(ParkingProcess parkingProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return ParkingProcess
     */
    ParkingProcess findById(Long id);
}
