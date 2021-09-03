package com.museum.service;

import com.museum.domain.AcademicPapers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-学术论文 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
public interface IAcademicPapersService extends IService<AcademicPapers> {

    /**
     * 查询数据中心-学术论文分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<AcademicPapers>
     */
    IPage<AcademicPapers> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-学术论文
     *
     * @param academicPapers 数据中心-学术论文
     * @return int
     */
    int add(AcademicPapers academicPapers);

    /**
     * 删除数据中心-学术论文
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-学术论文
     *
     * @param academicPapers 数据中心-学术论文
     * @return int
     */
    int updateData(AcademicPapers academicPapers);

    /**
     * id查询数据
     *
     * @param id id
     * @return AcademicPapers
     */
    AcademicPapers findById(Long id);
}
