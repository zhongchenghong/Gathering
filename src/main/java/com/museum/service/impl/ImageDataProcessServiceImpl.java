package com.museum.service.impl;

import com.museum.domain.ImageDataProcess;
import com.museum.dao.ImageDataProcessMapper;
import com.museum.service.IImageDataProcessService;
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
public class ImageDataProcessServiceImpl extends ServiceImpl<ImageDataProcessMapper, ImageDataProcess> implements IImageDataProcessService {

    @Override
    public  IPage<ImageDataProcess> findListByPage(Integer page, Integer pageCount){
        IPage<ImageDataProcess> wherePage = new Page<>(page, pageCount);
        ImageDataProcess where = new ImageDataProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ImageDataProcess imageDataProcess){
        return baseMapper.insert(imageDataProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ImageDataProcess imageDataProcess){
        return baseMapper.updateById(imageDataProcess);
    }

    @Override
    public ImageDataProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
