package com.museum.service;

import com.museum.domain.ExhibitionLinkage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 陈列展览三级联动 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
public interface IExhibitionLinkageService extends IService<ExhibitionLinkage> {

    /**
     * 查询陈列展览三级联动分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ExhibitionLinkage>
     */
    IPage<ExhibitionLinkage> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加陈列展览三级联动
     *
     * @param exhibitionLinkage 陈列展览三级联动
     * @return int
     */
    int add(ExhibitionLinkage exhibitionLinkage);

    /**
     * 删除陈列展览三级联动
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改陈列展览三级联动
     *
     * @param exhibitionLinkage 陈列展览三级联动
     * @return int
     */
    int updateData(ExhibitionLinkage exhibitionLinkage);

    /**
     * id查询数据
     *
     * @param id id
     * @return ExhibitionLinkage
     */
    ExhibitionLinkage findById(Long id);
}
