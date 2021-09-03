package com.museum.service;

import com.museum.domain.Trademark;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 文创产业部商标添加 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
public interface ITrademarkService extends IService<Trademark> {

    /**
     * 查询文创产业部商标添加分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Trademark>
     */
    IPage<Trademark> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加文创产业部商标添加
     *
     * @param trademark 文创产业部商标添加
     * @return int
     */
    int add(Trademark trademark);

    /**
     * 删除文创产业部商标添加
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改文创产业部商标添加
     *
     * @param trademark 文创产业部商标添加
     * @return int
     */
    int updateData(Trademark trademark);

    /**
     * id查询数据
     *
     * @param id id
     * @return Trademark
     */
    Trademark findById(Long id);
}
