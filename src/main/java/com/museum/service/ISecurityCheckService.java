package com.museum.service;

import com.museum.domain.SecurityCheck;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 锦里公司安全记录检查表 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
public interface ISecurityCheckService extends IService<SecurityCheck> {

    /**
     * 查询锦里公司安全记录检查表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<SecurityCheck>
     */
    IPage<SecurityCheck> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加锦里公司安全记录检查表
     *
     * @param securityCheck 锦里公司安全记录检查表
     * @return int
     */
    int add(SecurityCheck securityCheck);

    /**
     * 删除锦里公司安全记录检查表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改锦里公司安全记录检查表
     *
     * @param securityCheck 锦里公司安全记录检查表
     * @return int
     */
    int updateData(SecurityCheck securityCheck);

    /**
     * id查询数据
     *
     * @param id id
     * @return SecurityCheck
     */
    SecurityCheck findById(Long id);
}
