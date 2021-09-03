package com.museum.service.impl;

import com.museum.domain.LegalKnowledge;
import com.museum.dao.LegalKnowledgeMapper;
import com.museum.service.ILegalKnowledgeService;
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
 * @since 2021-07-08
 */
@Service
public class LegalKnowledgeServiceImpl extends ServiceImpl<LegalKnowledgeMapper, LegalKnowledge> implements ILegalKnowledgeService {

    @Override
    public  IPage<LegalKnowledge> findListByPage(Integer page, Integer pageCount){
        IPage<LegalKnowledge> wherePage = new Page<>(page, pageCount);
        LegalKnowledge where = new LegalKnowledge();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(LegalKnowledge legalKnowledge){
        return baseMapper.insert(legalKnowledge);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(LegalKnowledge legalKnowledge){
        return baseMapper.updateById(legalKnowledge);
    }

    @Override
    public LegalKnowledge findById(Long id){
        return  baseMapper.selectById(id);
    }
}
