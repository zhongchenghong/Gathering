package com.museum.service.impl;

import com.museum.domain.SendDocument;
import com.museum.dao.SendDocumentMapper;
import com.museum.service.ISendDocumentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 办公室公文管理-发文 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Service
public class SendDocumentServiceImpl extends ServiceImpl<SendDocumentMapper, SendDocument> implements ISendDocumentService {

    @Override
    public  IPage<SendDocument> findListByPage(Integer page, Integer pageCount){
        IPage<SendDocument> wherePage = new Page<>(page, pageCount);
        SendDocument where = new SendDocument();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(SendDocument sendDocument){
        return baseMapper.insert(sendDocument);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(SendDocument sendDocument){
        return baseMapper.updateById(sendDocument);
    }

    @Override
    public SendDocument findById(Long id){
        return  baseMapper.selectById(id);
    }
}
