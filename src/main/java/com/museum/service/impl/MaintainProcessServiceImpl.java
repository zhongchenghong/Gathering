package com.museum.service.impl;

import com.museum.domain.MaintainProcess;
import com.museum.dao.MaintainProcessMapper;
import com.museum.service.IMaintainProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 维护维修流程 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
@Service
public class MaintainProcessServiceImpl extends ServiceImpl<MaintainProcessMapper, MaintainProcess> implements IMaintainProcessService {

    @Override
    public  IPage<MaintainProcess> findListByPage(Integer page, Integer pageCount){
        IPage<MaintainProcess> wherePage = new Page<>(page, pageCount);
        MaintainProcess where = new MaintainProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(MaintainProcess maintainProcess){
        return baseMapper.insert(maintainProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(MaintainProcess maintainProcess){
        return baseMapper.updateById(maintainProcess);
    }

    @Override
    public MaintainProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
