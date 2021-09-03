package com.museum.service;

import com.museum.domain.DataCollection;
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
public interface IDataCollectionService extends IService<DataCollection> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<DataCollection>
     */
    IPage<DataCollection> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param dataCollection 
     * @return int
     */
    int add(DataCollection dataCollection);

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
     * @param dataCollection 
     * @return int
     */
    int updateData(DataCollection dataCollection);

    /**
     * id查询数据
     *
     * @param id id
     * @return DataCollection
     */
    DataCollection findById(Long id);
}
