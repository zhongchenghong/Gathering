package com.museum.service.impl;

import com.museum.domain.LubricateRecord;
import com.museum.dao.LubricateRecordMapper;
import com.museum.service.ILubricateRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 办公室加油登记 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Service
public class LubricateRecordServiceImpl extends ServiceImpl<LubricateRecordMapper, LubricateRecord> implements ILubricateRecordService {

    @Override
    public  IPage<LubricateRecord> findListByPage(Integer page, Integer pageCount){
        IPage<LubricateRecord> wherePage = new Page<>(page, pageCount);
        LubricateRecord where = new LubricateRecord();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(LubricateRecord lubricateRecord){
        return baseMapper.insert(lubricateRecord);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(LubricateRecord lubricateRecord){
        return baseMapper.updateById(lubricateRecord);
    }

    @Override
    public LubricateRecord findById(Long id){
        return  baseMapper.selectById(id);
    }
}
