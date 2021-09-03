package com.museum.service.impl;

import com.museum.domain.ImageData;
import com.museum.dao.ImageDataMapper;
import com.museum.service.IImageDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-15
 */
@Service
public class ImageDataServiceImpl extends ServiceImpl<ImageDataMapper, ImageData> implements IImageDataService {

    @Override
    public  IPage<ImageData> findListByPage(Integer page, Integer pageCount){
        IPage<ImageData> wherePage = new Page<>(page, pageCount);
        ImageData where = new ImageData();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ImageData imageData){
        return baseMapper.insert(imageData);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ImageData imageData){
        return baseMapper.updateById(imageData);
    }

    @Override
    public ImageData findById(Long id){
        return  baseMapper.selectById(id);
    }
}
