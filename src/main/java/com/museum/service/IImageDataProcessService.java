package com.museum.service;

import com.museum.domain.ImageDataProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-15
 */
public interface IImageDataProcessService extends IService<ImageDataProcess> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ImageDataProcess>
     */
    IPage<ImageDataProcess> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param imageDataProcess 
     * @return int
     */
    int add(ImageDataProcess imageDataProcess);

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
     * @param imageDataProcess 
     * @return int
     */
    int updateData(ImageDataProcess imageDataProcess);

    /**
     * id查询数据
     *
     * @param id id
     * @return ImageDataProcess
     */
    ImageDataProcess findById(Long id);
}
