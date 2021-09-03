package com.museum.service;

import com.museum.domain.GreenWaterBody;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-绿地水体面积 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
public interface IGreenWaterBodyService extends IService<GreenWaterBody> {

    /**
     * 查询数据中心-绿地水体面积分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<GreenWaterBody>
     */
    IPage<GreenWaterBody> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-绿地水体面积
     *
     * @param greenWaterBody 数据中心-绿地水体面积
     * @return int
     */
    int add(GreenWaterBody greenWaterBody);

    /**
     * 删除数据中心-绿地水体面积
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-绿地水体面积
     *
     * @param greenWaterBody 数据中心-绿地水体面积
     * @return int
     */
    int updateData(GreenWaterBody greenWaterBody);

    /**
     * id查询数据
     *
     * @param id id
     * @return GreenWaterBody
     */
    GreenWaterBody findById(Long id);
}
