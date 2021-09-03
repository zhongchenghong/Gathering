package com.museum.service.impl;

import com.museum.domain.Lecture;
import com.museum.dao.LectureMapper;
import com.museum.service.ILectureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-讲座数据管理 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Service
public class LectureServiceImpl extends ServiceImpl<LectureMapper, Lecture> implements ILectureService {

    @Override
    public  IPage<Lecture> findListByPage(Integer page, Integer pageCount){
        IPage<Lecture> wherePage = new Page<>(page, pageCount);
        Lecture where = new Lecture();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Lecture lecture){
        return baseMapper.insert(lecture);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Lecture lecture){
        return baseMapper.updateById(lecture);
    }

    @Override
    public Lecture findById(Long id){
        return  baseMapper.selectById(id);
    }
}
