package com.museum.service;

import com.museum.domain.OfficeGoodsInput;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 办公室物品录入 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-19
 */
public interface IOfficeGoodsInputService extends IService<OfficeGoodsInput> {

    /**
     * 查询办公室物品录入分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<OfficeGoodsInput>
     */
    IPage<OfficeGoodsInput> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加办公室物品录入
     *
     * @param officeGoodsInput 办公室物品录入
     * @return int
     */
    int add(OfficeGoodsInput officeGoodsInput);

    /**
     * 删除办公室物品录入
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改办公室物品录入
     *
     * @param officeGoodsInput 办公室物品录入
     * @return int
     */
    int updateData(OfficeGoodsInput officeGoodsInput);

    /**
     * id查询数据
     *
     * @param id id
     * @return OfficeGoodsInput
     */
    OfficeGoodsInput findById(Long id);
}
