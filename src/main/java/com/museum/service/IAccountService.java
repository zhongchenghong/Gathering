package com.museum.service;

import com.museum.domain.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-05-25
 */
public interface IAccountService extends IService<Account> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Account>
     */
    IPage<Account> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param account 
     * @return int
     */
    int add(Account account);

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
     * @param account 
     * @return int
     */
    int updateData(Account account);

    /**
     * id查询数据
     *
     * @param id id
     * @return Account
     */
    Account findById(Long id);

    HSSFWorkbook createContractExcel(List<Account> account);

    /**
     *token查找当前登录用户
     * @param req
     * @return
     */
    Account findAccount(HttpServletRequest req);
}
