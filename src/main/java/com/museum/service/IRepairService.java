package com.museum.service;

import com.museum.domain.Repair;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 办公室维保登记 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
public interface IRepairService extends IService<Repair> {

    /**
     * 查询办公室维保登记分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Repair>
     */
    IPage<Repair> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加办公室维保登记
     *
     * @param repair 办公室维保登记
     * @return int
     */
    int add(Repair repair);

    /**
     * 删除办公室维保登记
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改办公室维保登记
     *
     * @param repair 办公室维保登记
     * @return int
     */
    int updateData(Repair repair);

    /**
     * id查询数据
     *
     * @param id id
     * @return Repair
     */
    Repair findById(Long id);
}
