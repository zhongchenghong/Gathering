package com.museum.service;

import com.museum.domain.ScreenResources;
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
public interface IScreenResourcesService extends IService<ScreenResources> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ScreenResources>
     */
    IPage<ScreenResources> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param screenResources 
     * @return int
     */
    int add(ScreenResources screenResources);

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
     * @param screenResources 
     * @return int
     */
    int updateData(ScreenResources screenResources);

    /**
     * id查询数据
     *
     * @param id id
     * @return ScreenResources
     */
    ScreenResources findById(Long id);
}
