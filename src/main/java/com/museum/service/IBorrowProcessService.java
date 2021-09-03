package com.museum.service;

import com.museum.domain.BorrowProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 档案借阅流程 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-28
 */
public interface IBorrowProcessService extends IService<BorrowProcess> {

    /**
     * 查询档案借阅流程分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<BorrowProcess>
     */
    IPage<BorrowProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加档案借阅流程
     *
     * @param borrowProcess 档案借阅流程
     * @return int
     */
    int add(BorrowProcess borrowProcess);

    /**
     * 删除档案借阅流程
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改档案借阅流程
     *
     * @param borrowProcess 档案借阅流程
     * @return int
     */
    int updateData(BorrowProcess borrowProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return BorrowProcess
     */
    BorrowProcess findById(Long id);
}
