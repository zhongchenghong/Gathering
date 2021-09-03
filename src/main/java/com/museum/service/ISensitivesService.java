package com.museum.service;

import com.museum.domain.Sensitives;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-08
 */
public interface ISensitivesService extends IService<Sensitives> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Sensitives>
     */
    IPage<Sensitives> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param sensitives 
     * @return int
     */
    int add(Sensitives sensitives);

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
     * @param sensitives 
     * @return int
     */
    int updateData(Sensitives sensitives);

    /**
     * id查询数据
     *
     * @param id id
     * @return Sensitives
     */
    Sensitives findById(Long id);
}
