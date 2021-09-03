package com.museum.service;

import com.museum.domain.AccountMailList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-01
 */
public interface IAccountMailListService extends IService<AccountMailList> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<AccountMailList>
     */
    IPage<AccountMailList> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param accountMailList 
     * @return int
     */
    int add(AccountMailList accountMailList);

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
     * @param accountMailList 
     * @return int
     */
    int updateData(AccountMailList accountMailList);

    /**
     * id查询数据
     *
     * @param id id
     * @return AccountMailList
     */
    AccountMailList findById(Long id);
}
