package com.museum.service;

import com.museum.domain.GoodsInform;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 物品领用 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
public interface IGoodsInformService extends IService<GoodsInform> {

    /**
     * 查询物品领用分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<GoodsInform>
     */
    IPage<GoodsInform> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加物品领用
     *
     * @param goodsInform 物品领用
     * @return int
     */
    int add(GoodsInform goodsInform);

    /**
     * 删除物品领用
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改物品领用
     *
     * @param goodsInform 物品领用
     * @return int
     */
    int updateData(GoodsInform goodsInform);

    /**
     * id查询数据
     *
     * @param id id
     * @return GoodsInform
     */
    GoodsInform findById(Long id);
}
