package com.museum.service.impl;

import com.museum.domain.FileAccessProcess;
import com.museum.dao.FileAccessProcessMapper;
import com.museum.service.IFileAccessProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 资料采集制作流程表 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-22
 */
@Service
public class FileAccessProcessServiceImpl extends ServiceImpl<FileAccessProcessMapper, FileAccessProcess> implements IFileAccessProcessService {

    @Override
    public  IPage<FileAccessProcess> findListByPage(Integer page, Integer pageCount){
        IPage<FileAccessProcess> wherePage = new Page<>(page, pageCount);
        FileAccessProcess where = new FileAccessProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(FileAccessProcess fileAccessProcess){
        return baseMapper.insert(fileAccessProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(FileAccessProcess fileAccessProcess){
        return baseMapper.updateById(fileAccessProcess);
    }

    @Override
    public FileAccessProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
