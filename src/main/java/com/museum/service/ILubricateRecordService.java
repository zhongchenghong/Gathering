package com.museum.service;

import com.museum.domain.LubricateRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 办公室加油登记 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
public interface ILubricateRecordService extends IService<LubricateRecord> {

    /**
     * 查询办公室加油登记分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<LubricateRecord>
     */
    IPage<LubricateRecord> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加办公室加油登记
     *
     * @param lubricateRecord 办公室加油登记
     * @return int
     */
    int add(LubricateRecord lubricateRecord);

    /**
     * 删除办公室加油登记
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改办公室加油登记
     *
     * @param lubricateRecord 办公室加油登记
     * @return int
     */
    int updateData(LubricateRecord lubricateRecord);

    /**
     * id查询数据
     *
     * @param id id
     * @return LubricateRecord
     */
    LubricateRecord findById(Long id);
}
