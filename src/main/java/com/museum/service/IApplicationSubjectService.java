package com.museum.service;

import com.museum.domain.ApplicationSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 财务部各个科目 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
public interface IApplicationSubjectService extends IService<ApplicationSubject> {

    /**
     * 查询财务部各个科目分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ApplicationSubject>
     */
    IPage<ApplicationSubject> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加财务部各个科目
     *
     * @param applicationSubject 财务部各个科目
     * @return int
     */
    int add(ApplicationSubject applicationSubject);

    /**
     * 删除财务部各个科目
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改财务部各个科目
     *
     * @param applicationSubject 财务部各个科目
     * @return int
     */
    int updateData(ApplicationSubject applicationSubject);

    /**
     * id查询数据
     *
     * @param id id
     * @return ApplicationSubject
     */
    ApplicationSubject findById(Long id);
}
