package com.museum.service.impl;

import com.museum.domain.Receipt;
import com.museum.dao.ReceiptMapper;
import com.museum.service.IReceiptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 办公室-收文 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Service
public class ReceiptServiceImpl extends ServiceImpl<ReceiptMapper, Receipt> implements IReceiptService {

    @Override
    public  IPage<Receipt> findListByPage(Integer page, Integer pageCount){
        IPage<Receipt> wherePage = new Page<>(page, pageCount);
        Receipt where = new Receipt();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Receipt receipt){
        return baseMapper.insert(receipt);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Receipt receipt){
        return baseMapper.updateById(receipt);
    }

    @Override
    public Receipt findById(Long id){
        return  baseMapper.selectById(id);
    }
}
