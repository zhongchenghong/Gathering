package com.museum.service;

import com.museum.domain.Charge;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 数据中心-电力符合数 服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
public interface IChargeService extends IService<Charge> {

    /**
     * 查询数据中心-电力符合数分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Charge>
     */
    IPage<Charge> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加数据中心-电力符合数
     *
     * @param charge 数据中心-电力符合数
     * @return int
     */
    int add(Charge charge);

    /**
     * 删除数据中心-电力符合数
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改数据中心-电力符合数
     *
     * @param charge 数据中心-电力符合数
     * @return int
     */
    int updateData(Charge charge);

    /**
     * id查询数据
     *
     * @param id id
     * @return Charge
     */
    Charge findById(Long id);
}
