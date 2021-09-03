package com.museum.service.impl;

import com.museum.common.sensitive.SensitiveWordInit;
import com.museum.domain.Sensitives;
import com.museum.dao.SensitivesMapper;
import com.museum.service.ISensitivesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-06-08
 */
@Service
public class SensitivesServiceImpl extends ServiceImpl<SensitivesMapper, Sensitives> implements ISensitivesService {

    @Override
    public  IPage<Sensitives> findListByPage(Integer page, Integer pageCount){
        IPage<Sensitives> wherePage = new Page<>(page, pageCount);
        Sensitives where = new Sensitives();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Sensitives sensitives){
        return baseMapper.insert(sensitives);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Sensitives sensitives){
        return baseMapper.updateById(sensitives);
    }

    @Override
    public Sensitives findById(Long id){
        return  baseMapper.selectById(id);
    }


}
