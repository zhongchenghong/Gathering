package com.museum.service;

import com.museum.domain.TicketType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 财务票价类型 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 */
public interface ITicketTypeService extends IService<TicketType> {

    /**
     * 查询财务票价类型分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<TicketType>
     */
    IPage<TicketType> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加财务票价类型
     *
     * @param ticketType 财务票价类型
     * @return int
     */
    int add(TicketType ticketType);

    /**
     * 删除财务票价类型
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改财务票价类型
     *
     * @param ticketType 财务票价类型
     * @return int
     */
    int updateData(TicketType ticketType);

    /**
     * id查询数据
     *
     * @param id id
     * @return TicketType
     */
    TicketType findById(Long id);
}
