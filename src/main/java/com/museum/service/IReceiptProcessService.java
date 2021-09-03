package com.museum.service;

import com.museum.domain.ReceiptProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 办公室--收文 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-24
 */
public interface IReceiptProcessService extends IService<ReceiptProcess> {

    /**
     * 查询办公室--收文分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ReceiptProcess>
     */
    IPage<ReceiptProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加办公室--收文
     *
     * @param receiptProcess 办公室--收文
     * @return int
     */
    int add(ReceiptProcess receiptProcess);

    /**
     * 删除办公室--收文
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改办公室--收文
     *
     * @param receiptProcess 办公室--收文
     * @return int
     */
    int updateData(ReceiptProcess receiptProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return ReceiptProcess
     */
    ReceiptProcess findById(Long id);
}
