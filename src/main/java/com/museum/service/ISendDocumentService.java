package com.museum.service;

import com.museum.domain.SendDocument;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 办公室公文管理-发文 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
public interface ISendDocumentService extends IService<SendDocument> {

    /**
     * 查询办公室公文管理-发文分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<SendDocument>
     */
    IPage<SendDocument> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加办公室公文管理-发文
     *
     * @param sendDocument 办公室公文管理-发文
     * @return int
     */
    int add(SendDocument sendDocument);

    /**
     * 删除办公室公文管理-发文
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改办公室公文管理-发文
     *
     * @param sendDocument 办公室公文管理-发文
     * @return int
     */
    int updateData(SendDocument sendDocument);

    /**
     * id查询数据
     *
     * @param id id
     * @return SendDocument
     */
    SendDocument findById(Long id);
}
