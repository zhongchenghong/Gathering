package com.museum.service;

import com.museum.domain.Lecture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-讲座数据管理 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
public interface ILectureService extends IService<Lecture> {

    /**
     * 查询数据中心-讲座数据管理分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Lecture>
     */
    IPage<Lecture> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-讲座数据管理
     *
     * @param lecture 数据中心-讲座数据管理
     * @return int
     */
    int add(Lecture lecture);

    /**
     * 删除数据中心-讲座数据管理
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-讲座数据管理
     *
     * @param lecture 数据中心-讲座数据管理
     * @return int
     */
    int updateData(Lecture lecture);

    /**
     * id查询数据
     *
     * @param id id
     * @return Lecture
     */
    Lecture findById(Long id);
}
