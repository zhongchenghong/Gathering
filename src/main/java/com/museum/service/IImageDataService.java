package com.museum.service;

import com.museum.domain.ImageData;
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
public interface IImageDataService extends IService<ImageData> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ImageData>
     */
    IPage<ImageData> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param imageData 
     * @return int
     */
    int add(ImageData imageData);

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
     * @param imageData 
     * @return int
     */
    int updateData(ImageData imageData);

    /**
     * id查询数据
     *
     * @param id id
     * @return ImageData
     */
    ImageData findById(Long id);
}
