package com.museum.service;

import com.museum.domain.CarRegister;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 新车登记 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
public interface ICarRegisterService extends IService<CarRegister> {

    /**
     * 查询新车登记分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<CarRegister>
     */
    IPage<CarRegister> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加新车登记
     *
     * @param carRegister 新车登记
     * @return int
     */
    int add(CarRegister carRegister);

    /**
     * 删除新车登记
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改新车登记
     *
     * @param carRegister 新车登记
     * @return int
     */
    int updateData(CarRegister carRegister);

    /**
     * id查询数据
     *
     * @param id id
     * @return CarRegister
     */
    CarRegister findById(Long id);
}
