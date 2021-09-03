package com.museum.service;

import com.museum.domain.GoodsProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 资料采集制作流程表 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
public interface IGoodsProcessService extends IService<GoodsProcess> {

    /**
     * 查询资料采集制作流程表分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<GoodsProcess>
     */
    IPage<GoodsProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加资料采集制作流程表
     *
     * @param goodsProcess 资料采集制作流程表
     * @return int
     */
    int add(GoodsProcess goodsProcess);

    /**
     * 删除资料采集制作流程表
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改资料采集制作流程表
     *
     * @param goodsProcess 资料采集制作流程表
     * @return int
     */
    int updateData(GoodsProcess goodsProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return GoodsProcess
     */
    GoodsProcess findById(Long id);
}
