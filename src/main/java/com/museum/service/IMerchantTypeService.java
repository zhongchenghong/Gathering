package com.museum.service;

import com.museum.domain.MerchantType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
public interface IMerchantTypeService extends IService<MerchantType> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<MerchantType>
     */
    IPage<MerchantType> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param merchantType 
     * @return int
     */
    int add(MerchantType merchantType);

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
     * @param merchantType 
     * @return int
     */
    int updateData(MerchantType merchantType);

    /**
     * id查询数据
     *
     * @param id id
     * @return MerchantType
     */
    MerchantType findById(Long id);
}
