package com.museum.service.impl;

import com.museum.domain.SecurityCheck;
import com.museum.dao.SecurityCheckMapper;
import com.museum.service.ISecurityCheckService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 锦里公司安全记录检查表 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Service
public class SecurityCheckServiceImpl extends ServiceImpl<SecurityCheckMapper, SecurityCheck> implements ISecurityCheckService {

    @Override
    public  IPage<SecurityCheck> findListByPage(Integer page, Integer pageCount){
        IPage<SecurityCheck> wherePage = new Page<>(page, pageCount);
        SecurityCheck where = new SecurityCheck();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(SecurityCheck securityCheck){
        return baseMapper.insert(securityCheck);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(SecurityCheck securityCheck){
        return baseMapper.updateById(securityCheck);
    }

    @Override
    public SecurityCheck findById(Long id){
        return  baseMapper.selectById(id);
    }
}
