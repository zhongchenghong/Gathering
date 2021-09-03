package com.museum.service;

import com.museum.domain.Authentication;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-08
 */
public interface IAuthenticationService extends IService<Authentication> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Authentication>
     */
    IPage<Authentication> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param authentication 
     * @return int
     */
    int add(Authentication authentication);

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
     * @param authentication 
     * @return int
     */
    int updateData(Authentication authentication);

    /**
     * id查询数据
     *
     * @param id id
     * @return Authentication
     */
    Authentication findById(Long id);
}
