package com.museum.service;

import com.museum.domain.BorrowingResults;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-30
 */
public interface IBorrowingResultsService extends IService<BorrowingResults> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<BorrowingResults>
     */
    IPage<BorrowingResults> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param borrowingResults 
     * @return int
     */
    int add(BorrowingResults borrowingResults);

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
     * @param borrowingResults 
     * @return int
     */
    int updateData(BorrowingResults borrowingResults);

    /**
     * id查询数据
     *
     * @param id id
     * @return BorrowingResults
     */
    BorrowingResults findById(Long id);
}
