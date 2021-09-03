package com.museum.service.impl;

import com.museum.domain.AncientArchitecture;
import com.museum.dao.AncientArchitectureMapper;
import com.museum.service.IAncientArchitectureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 数据中心-古建数据 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Service
public class AncientArchitectureServiceImpl extends ServiceImpl<AncientArchitectureMapper, AncientArchitecture> implements IAncientArchitectureService {

    @Override
    public  IPage<AncientArchitecture> findListByPage(Integer page, Integer pageCount){
        IPage<AncientArchitecture> wherePage = new Page<>(page, pageCount);
        AncientArchitecture where = new AncientArchitecture();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(AncientArchitecture ancientArchitecture){
        return baseMapper.insert(ancientArchitecture);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(AncientArchitecture ancientArchitecture){
        return baseMapper.updateById(ancientArchitecture);
    }

    @Override
    public AncientArchitecture findById(Long id){
        return  baseMapper.selectById(id);
    }
}
