package com.museum.service;

import com.museum.domain.BorrowForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-26
 */
public interface IBorrowFormService extends IService<BorrowForm> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<BorrowForm>
     */
    IPage<BorrowForm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param borrowForm 
     * @return int
     */
    int add(BorrowForm borrowForm);

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
     * @param borrowForm 
     * @return int
     */
    int updateData(BorrowForm borrowForm);

    /**
     * id查询数据
     *
     * @param id id
     * @return BorrowForm
     */
    BorrowForm findById(Long id);
}
