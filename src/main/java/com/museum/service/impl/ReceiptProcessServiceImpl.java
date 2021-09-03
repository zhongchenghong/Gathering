package com.museum.service.impl;

import com.museum.domain.ReceiptProcess;
import com.museum.dao.ReceiptProcessMapper;
import com.museum.service.IReceiptProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 办公室--收文 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-24
 */
@Service
public class ReceiptProcessServiceImpl extends ServiceImpl<ReceiptProcessMapper, ReceiptProcess> implements IReceiptProcessService {

    @Override
    public  IPage<ReceiptProcess> findListByPage(Integer page, Integer pageCount){
        IPage<ReceiptProcess> wherePage = new Page<>(page, pageCount);
        ReceiptProcess where = new ReceiptProcess();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ReceiptProcess receiptProcess){
        return baseMapper.insert(receiptProcess);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ReceiptProcess receiptProcess){
        return baseMapper.updateById(receiptProcess);
    }

    @Override
    public ReceiptProcess findById(Long id){
        return  baseMapper.selectById(id);
    }
}
