package com.museum.service.impl;

import com.museum.domain.PostForm;
import com.museum.dao.PostFormMapper;
import com.museum.service.IPostFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 发文申请 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-21
 */
@Service
public class PostFormServiceImpl extends ServiceImpl<PostFormMapper, PostForm> implements IPostFormService {

    @Override
    public  IPage<PostForm> findListByPage(Integer page, Integer pageCount){
        IPage<PostForm> wherePage = new Page<>(page, pageCount);
        PostForm where = new PostForm();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(PostForm postForm){
        return baseMapper.insert(postForm);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(PostForm postForm){
        return baseMapper.updateById(postForm);
    }

    @Override
    public PostForm findById(Long id){
        return  baseMapper.selectById(id);
    }
}
