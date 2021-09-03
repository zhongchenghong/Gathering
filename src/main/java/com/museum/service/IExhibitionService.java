package com.museum.service;

import com.museum.domain.ActivityEntryCountByYear;
import com.museum.domain.Exhibition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 陈列展览表单 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
public interface IExhibitionService extends IService<Exhibition> {

    /**
     * 查询陈列展览表单分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Exhibition>
     */
    IPage<Exhibition> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加陈列展览表单
     *
     * @param exhibition 陈列展览表单
     * @return int
     */
    int add(Exhibition exhibition);

    /**
     * 删除陈列展览表单
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改陈列展览表单
     *
     * @param exhibition 陈列展览表单
     * @return int
     */
    int updateData(Exhibition exhibition);

    /**
     * id查询数据
     *
     * @param id id
     * @return Exhibition
     */
    Exhibition findById(Long id);

    /**
     *陈列展览按年统计
     * @return
     */

    List<ActivityEntryCountByYear> getcountByYear();

    /**
     *饼状图统计
     */
    List<ActivityEntryCountByYear> getcountBytype(String  year);
}
