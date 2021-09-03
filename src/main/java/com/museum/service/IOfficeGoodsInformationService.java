package com.museum.service;

import com.museum.domain.OfficeGoodsInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 办公室录入物品名称 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-19
 */
public interface IOfficeGoodsInformationService extends IService<OfficeGoodsInformation> {

    /**
     * 查询办公室录入物品名称分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<OfficeGoodsInformation>
     */
    IPage<OfficeGoodsInformation> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加办公室录入物品名称
     *
     * @param officeGoodsInformation 办公室录入物品名称
     * @return int
     */
    int add(OfficeGoodsInformation officeGoodsInformation);

    /**
     * 删除办公室录入物品名称
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改办公室录入物品名称
     *
     * @param officeGoodsInformation 办公室录入物品名称
     * @return int
     */
    int updateData(OfficeGoodsInformation officeGoodsInformation);

    /**
     * id查询数据
     *
     * @param id id
     * @return OfficeGoodsInformation
     */
    OfficeGoodsInformation findById(Long id);
}
