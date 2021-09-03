package com.museum.service.impl;

import com.museum.domain.AcademicPapers;
import com.museum.dao.AcademicPapersMapper;
import com.museum.service.IAcademicPapersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-学术论文 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Service
public class AcademicPapersServiceImpl extends ServiceImpl<AcademicPapersMapper, AcademicPapers> implements IAcademicPapersService {

    @Override
    public  IPage<AcademicPapers> findListByPage(Integer page, Integer pageCount){
        IPage<AcademicPapers> wherePage = new Page<>(page, pageCount);
        AcademicPapers where = new AcademicPapers();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(AcademicPapers academicPapers){
        return baseMapper.insert(academicPapers);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(AcademicPapers academicPapers){
        return baseMapper.updateById(academicPapers);
    }

    @Override
    public AcademicPapers findById(Long id){
        return  baseMapper.selectById(id);
    }
}
