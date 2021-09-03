package com.museum.service;

import com.museum.domain.Branchlibrary;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 分管馆长跟部门绑定 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-28
 */
public interface IBranchlibraryService extends IService<Branchlibrary> {

    /**
     * 查询分管馆长跟部门绑定分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Branchlibrary>
     */
    IPage<Branchlibrary> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加分管馆长跟部门绑定
     *
     * @param branchlibrary 分管馆长跟部门绑定
     * @return int
     */
    int add(Branchlibrary branchlibrary);

    /**
     * 删除分管馆长跟部门绑定
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改分管馆长跟部门绑定
     *
     * @param branchlibrary 分管馆长跟部门绑定
     * @return int
     */
    int updateData(Branchlibrary branchlibrary);

    /**
     * id查询数据
     *
     * @param id id
     * @return Branchlibrary
     */
    Branchlibrary findById(Long id);
}
