package com.museum.service.impl;

import com.museum.domain.FileAccessForm;
import com.museum.dao.FileAccessFormMapper;
import com.museum.service.IFileAccessFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 档案查阅表单 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
@Service
public class FileAccessFormServiceImpl extends ServiceImpl<FileAccessFormMapper, FileAccessForm> implements IFileAccessFormService {

    @Override
    public  IPage<FileAccessForm> findListByPage(Integer page, Integer pageCount){
        IPage<FileAccessForm> wherePage = new Page<>(page, pageCount);
        FileAccessForm where = new FileAccessForm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(FileAccessForm fileAccessForm){
        return baseMapper.insert(fileAccessForm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(FileAccessForm fileAccessForm){
        return baseMapper.updateById(fileAccessForm);
    }

    @Override
    public FileAccessForm findById(Long id){
        return  baseMapper.selectById(id);
    }
}
