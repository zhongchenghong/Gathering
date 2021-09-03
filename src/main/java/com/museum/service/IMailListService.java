package com.museum.service;

import com.museum.domain.AccountList;
import com.museum.domain.MailList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-01
 */
public interface IMailListService extends IService<MailList> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<MailList>
     */
    IPage<MailList> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param mailList 
     * @return int
     */
    int add(MailList mailList);

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
     * @param mailList 
     * @return int
     */
    int updateData(MailList mailList);

    /**
     * id查询数据
     *
     * @param id id
     * @return MailList
     */
    MailList findById(Long id);

    /**
     * 查询通讯录分组数据
     * @param id
     * @param uid
     * @return
     */
    List<AccountList> accountList(int id,int uid);

    /**
     * 查询通讯录所有数据
     * @param uid
     * @return
     */
    List<AccountList> accounttotalList(String name,int uid);
}
