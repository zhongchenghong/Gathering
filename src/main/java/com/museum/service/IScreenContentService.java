package com.museum.service;

import com.museum.domain.ScreenContent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-29
 */
public interface IScreenContentService extends IService<ScreenContent> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ScreenContent>
     */
    IPage<ScreenContent> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param screenContent 
     * @return int
     */
    int add(ScreenContent screenContent);

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
     * @param screenContent 
     * @return int
     */
    int updateData(ScreenContent screenContent);

    /**
     * id查询数据
     *
     * @param id id
     * @return ScreenContent
     */
    ScreenContent findById(Long id);
}
