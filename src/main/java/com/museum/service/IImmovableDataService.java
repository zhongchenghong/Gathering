package com.museum.service;

import com.museum.domain.ImmovableData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-不可移动文物数据 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
public interface IImmovableDataService extends IService<ImmovableData> {

    /**
     * 查询数据中心-不可移动文物数据分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ImmovableData>
     */
    IPage<ImmovableData> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-不可移动文物数据
     *
     * @param immovableData 数据中心-不可移动文物数据
     * @return int
     */
    int add(ImmovableData immovableData);

    /**
     * 删除数据中心-不可移动文物数据
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-不可移动文物数据
     *
     * @param immovableData 数据中心-不可移动文物数据
     * @return int
     */
    int updateData(ImmovableData immovableData);

    /**
     * id查询数据
     *
     * @param id id
     * @return ImmovableData
     */
    ImmovableData findById(Long id);
}
