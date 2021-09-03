package com.museum.service.impl;

import com.museum.domain.SocialSecurityProcess;
import com.museum.dao.SocialSecurityProcessMapper;
import com.museum.service.ISocialSecurityProcessService;
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
 * @since 2021-07-12
 */
@Service
public class SocialSecurityProcessServiceImpl extends ServiceImpl<SocialSecurityProcessMapper, SocialSecurityProcess> implements ISocialSecurityProcessService {

    @Override
    public  IPage<SocialSecurityProcess> findListByPage(Integer page, Integer pageCount){
        IPage<SocialSecurityProcess> wherePage = new Page<>(page, pageCount);
        SocialSecurityProcess where = new SocialSecurityProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(SocialSecurityProcess socialSecurityProcess){
        return baseMapper.insert(socialSecurityProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(SocialSecurityProcess socialSecurityProcess){
        return baseMapper.updateById(socialSecurityProcess);
    }

    @Override
    public SocialSecurityProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
