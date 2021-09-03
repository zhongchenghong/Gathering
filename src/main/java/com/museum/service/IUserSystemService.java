package com.museum.service;

import com.museum.domain.UserSystem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-05-20
 */
public interface IUserSystemService extends IService<UserSystem> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<UserSystem>
     */
    IPage<UserSystem> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param userSystem 
     * @return int
     */
    int add(UserSystem userSystem);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param userSystem 
     * @return int
     */
    int updateData(UserSystem userSystem);

    /**
     * id查询数据
     *
     * @param id id
     * @return UserSystem
     */
    UserSystem findById(Long id);
}
