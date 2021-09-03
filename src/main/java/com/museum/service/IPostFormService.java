package com.museum.service;

import com.museum.domain.PostForm;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 发文申请 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-21
 */
public interface IPostFormService extends IService<PostForm> {

    /**
     * 查询发文申请分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<PostForm>
     */
    IPage<PostForm> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加发文申请
     *
     * @param postForm 发文申请
     * @return int
     */
    int add(PostForm postForm);

    /**
     * 删除发文申请
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改发文申请
     *
     * @param postForm 发文申请
     * @return int
     */
    int updateData(PostForm postForm);

    /**
     * id查询数据
     *
     * @param id id
     * @return PostForm
     */
    PostForm findById(Long id);
}
