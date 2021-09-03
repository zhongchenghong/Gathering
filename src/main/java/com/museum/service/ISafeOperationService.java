package com.museum.service;

import com.museum.domain.SafeOperation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 泰合信息安全运营中心系统 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-27
 */
public interface ISafeOperationService extends IService<SafeOperation> {

    /**
     * 查询泰合信息安全运营中心系统分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<SafeOperation>
     */
    IPage<SafeOperation> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加泰合信息安全运营中心系统
     *
     * @param safeOperation 泰合信息安全运营中心系统
     * @return int
     */
    int add(SafeOperation safeOperation);

    /**
     * 删除泰合信息安全运营中心系统
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改泰合信息安全运营中心系统
     *
     * @param safeOperation 泰合信息安全运营中心系统
     * @return int
     */
    int updateData(SafeOperation safeOperation);

    /**
     * id查询数据
     *
     * @param id id
     * @return SafeOperation
     */
    SafeOperation findById(Long id);
}
