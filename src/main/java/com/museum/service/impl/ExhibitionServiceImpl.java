package com.museum.service.impl;

import com.museum.domain.ActivityEntryCountByYear;
import com.museum.domain.Exhibition;
import com.museum.dao.ExhibitionMapper;
import com.museum.service.IExhibitionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * <p>
 * 陈列展览表单 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
@Service
public class ExhibitionServiceImpl extends ServiceImpl<ExhibitionMapper, Exhibition> implements IExhibitionService {

    @Override
    public  IPage<Exhibition> findListByPage(Integer page, Integer pageCount){
        IPage<Exhibition> wherePage = new Page<>(page, pageCount);
        Exhibition where = new Exhibition();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Exhibition exhibition){
        return baseMapper.insert(exhibition);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Exhibition exhibition){
        return baseMapper.updateById(exhibition);
    }

    @Override
    public Exhibition findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<ActivityEntryCountByYear> getcountByYear() {
        return baseMapper.getcountByYear();
    }

    @Override
    public List<ActivityEntryCountByYear> getcountBytype(String year) {
        return baseMapper.getcountBytype(year);
    }
}
