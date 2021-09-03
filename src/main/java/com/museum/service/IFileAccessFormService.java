package com.museum.service;

import com.museum.domain.FileAccessForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 档案查阅表单 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
public interface IFileAccessFormService extends IService<FileAccessForm> {

    /**
     * 查询档案查阅表单分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<FileAccessForm>
     */
    IPage<FileAccessForm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加档案查阅表单
     *
     * @param fileAccessForm 档案查阅表单
     * @return int
     */
    int add(FileAccessForm fileAccessForm);

    /**
     * 删除档案查阅表单
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改档案查阅表单
     *
     * @param fileAccessForm 档案查阅表单
     * @return int
     */
    int updateData(FileAccessForm fileAccessForm);

    /**
     * id查询数据
     *
     * @param id id
     * @return FileAccessForm
     */
    FileAccessForm findById(Long id);
}
