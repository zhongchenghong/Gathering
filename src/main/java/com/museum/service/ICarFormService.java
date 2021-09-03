package com.museum.service;

import com.museum.domain.CarForm;
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
public interface ICarFormService extends IService<CarForm> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<CarForm>
     */
    IPage<CarForm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param carForm 
     * @return int
     */
    int add(CarForm carForm);

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
     * @param carForm 
     * @return int
     */
    int updateData(CarForm carForm);

    /**
     * id查询数据
     *
     * @param id id
     * @return CarForm
     */
    CarForm findById(Long id);
}
