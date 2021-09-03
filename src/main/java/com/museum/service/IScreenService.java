package com.museum.service;

import com.museum.domain.Screen;
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
public interface IScreenService extends IService<Screen> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Screen>
     */
    IPage<Screen> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param screen 
     * @return int
     */
    int add(Screen screen);

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
     * @param screen 
     * @return int
     */
    int updateData(Screen screen);

    /**
     * id查询数据
     *
     * @param id id
     * @return Screen
     */
    Screen findById(Long id);
}
