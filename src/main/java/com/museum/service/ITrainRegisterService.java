package com.museum.service;

import com.museum.domain.TrainRegister;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 锦里培训登记 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
public interface ITrainRegisterService extends IService<TrainRegister> {

    /**
     * 查询锦里培训登记分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<TrainRegister>
     */
    IPage<TrainRegister> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加锦里培训登记
     *
     * @param trainRegister 锦里培训登记
     * @return int
     */
    int add(TrainRegister trainRegister);

    /**
     * 删除锦里培训登记
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改锦里培训登记
     *
     * @param trainRegister 锦里培训登记
     * @return int
     */
    int updateData(TrainRegister trainRegister);

    /**
     * id查询数据
     *
     * @param id id
     * @return TrainRegister
     */
    TrainRegister findById(Long id);
}
