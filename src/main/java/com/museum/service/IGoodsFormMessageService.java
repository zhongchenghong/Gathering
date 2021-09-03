package com.museum.service;

import com.museum.domain.GoodsFormMessage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
public interface IGoodsFormMessageService extends IService<GoodsFormMessage> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<GoodsFormMessage>
     */
    IPage<GoodsFormMessage> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param goodsFormMessage 
     * @return int
     */
    int add(GoodsFormMessage goodsFormMessage);

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
     * @param goodsFormMessage 
     * @return int
     */
    int updateData(GoodsFormMessage goodsFormMessage);

    /**
     * id查询数据
     *
     * @param id id
     * @return GoodsFormMessage
     */
    GoodsFormMessage findById(Long id);
}
