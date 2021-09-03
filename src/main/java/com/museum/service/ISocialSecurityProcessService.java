package com.museum.service;

import com.museum.domain.SocialSecurityProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-12
 */
public interface ISocialSecurityProcessService extends IService<SocialSecurityProcess> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<SocialSecurityProcess>
     */
    IPage<SocialSecurityProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param socialSecurityProcess 
     * @return int
     */
    int add(SocialSecurityProcess socialSecurityProcess);

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
     * @param socialSecurityProcess 
     * @return int
     */
    int updateData(SocialSecurityProcess socialSecurityProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return SocialSecurityProcess
     */
    SocialSecurityProcess findById(Long id);
}
