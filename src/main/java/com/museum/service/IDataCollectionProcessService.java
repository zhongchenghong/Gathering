package com.museum.service;

import com.museum.domain.DataCollectionProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-20
 */
public interface IDataCollectionProcessService extends IService<DataCollectionProcess> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<DataCollectionProcess>
     */
    IPage<DataCollectionProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param dataCollectionProcess 
     * @return int
     */
    int add(DataCollectionProcess dataCollectionProcess);

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
     * @param dataCollectionProcess 
     * @return int
     */
    int updateData(DataCollectionProcess dataCollectionProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return DataCollectionProcess
     */
    DataCollectionProcess findById(Long id);
}
