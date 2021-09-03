package com.museum.service;

import com.museum.domain.Receipt;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 办公室-收文 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
public interface IReceiptService extends IService<Receipt> {

    /**
     * 查询办公室-收文分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Receipt>
     */
    IPage<Receipt> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加办公室-收文
     *
     * @param receipt 办公室-收文
     * @return int
     */
    int add(Receipt receipt);

    /**
     * 删除办公室-收文
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改办公室-收文
     *
     * @param receipt 办公室-收文
     * @return int
     */
    int updateData(Receipt receipt);

    /**
     * id查询数据
     *
     * @param id id
     * @return Receipt
     */
    Receipt findById(Long id);
}
