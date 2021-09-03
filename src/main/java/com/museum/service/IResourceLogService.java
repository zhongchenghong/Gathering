package com.museum.service;

import com.museum.domain.ResourceLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-06-18
 */
public interface IResourceLogService extends IService<ResourceLog> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ResourceLog>
     */
    IPage<ResourceLog> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param resourceLog 
     * @return int
     */
    int add(ResourceLog resourceLog);

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
     * @param resourceLog 
     * @return int
     */
    int updateData(ResourceLog resourceLog);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResourceLog
     */
    ResourceLog findById(Long id);

    HSSFWorkbook createContractExcel(List<ResourceLog> list);
}
