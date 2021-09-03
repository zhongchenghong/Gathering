package com.museum.service;

import com.museum.domain.LegalKnowledge;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-07-08
 */
public interface ILegalKnowledgeService extends IService<LegalKnowledge> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<LegalKnowledge>
     */
    IPage<LegalKnowledge> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param legalKnowledge 
     * @return int
     */
    int add(LegalKnowledge legalKnowledge);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param legalKnowledge 
     * @return int
     */
    int updateData(LegalKnowledge legalKnowledge);

    /**
     * id查询数据
     *
     * @param id id
     * @return LegalKnowledge
     */
    LegalKnowledge findById(Long id);
}
