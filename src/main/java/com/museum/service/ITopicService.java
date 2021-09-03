package com.museum.service;

import com.museum.domain.Topic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-学术课题数据 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
public interface ITopicService extends IService<Topic> {

    /**
     * 查询数据中心-学术课题数据分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Topic>
     */
    IPage<Topic> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-学术课题数据
     *
     * @param topic 数据中心-学术课题数据
     * @return int
     */
    int add(Topic topic);

    /**
     * 删除数据中心-学术课题数据
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-学术课题数据
     *
     * @param topic 数据中心-学术课题数据
     * @return int
     */
    int updateData(Topic topic);

    /**
     * id查询数据
     *
     * @param id id
     * @return Topic
     */
    Topic findById(Long id);
}
