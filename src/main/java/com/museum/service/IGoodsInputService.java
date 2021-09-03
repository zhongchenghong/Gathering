package com.museum.service;

import com.museum.domain.GoodsInput;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
public interface IGoodsInputService extends IService<GoodsInput> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<GoodsInput>
     */
    IPage<GoodsInput> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param goodsInput 
     * @return int
     */
    int add(GoodsInput goodsInput);

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
     * @param goodsInput 
     * @return int
     */
    int updateData(GoodsInput goodsInput);

    /**
     * id查询数据
     *
     * @param id id
     * @return GoodsInput
     */
    GoodsInput findById(Long id);


    /**
     * 获取设备总数
     * @return
     */
    String totail();

    /**
     * 获取固产和耗材
     * @return
     */
    String selectBytype(String type);
}
