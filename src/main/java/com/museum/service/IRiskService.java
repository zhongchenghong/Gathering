package com.museum.service;

import com.museum.domain.Risk;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 车辆保险险种 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
public interface IRiskService extends IService<Risk> {

    /**
     * 查询车辆保险险种分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Risk>
     */
    IPage<Risk> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加车辆保险险种
     *
     * @param risk 车辆保险险种
     * @return int
     */
    int add(Risk risk);

    /**
     * 删除车辆保险险种
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改车辆保险险种
     *
     * @param risk 车辆保险险种
     * @return int
     */
    int updateData(Risk risk);

    /**
     * id查询数据
     *
     * @param id id
     * @return Risk
     */
    Risk findById(Long id);
}
