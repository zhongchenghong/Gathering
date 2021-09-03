package com.museum.service.impl;

import com.museum.domain.JLProportion;
import com.museum.domain.JlCount;
import com.museum.domain.MerchantStatistics;
import com.museum.dao.MerchantStatisticsMapper;
import com.museum.service.IMerchantStatisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * <p>
 * 锦里商户统计、商户列表 服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
@Service
public class MerchantStatisticsServiceImpl extends ServiceImpl<MerchantStatisticsMapper, MerchantStatistics> implements IMerchantStatisticsService {

    @Override
    public  IPage<MerchantStatistics> findListByPage(Integer page, Integer pageCount){
        IPage<MerchantStatistics> wherePage = new Page<>(page, pageCount);
        MerchantStatistics where = new MerchantStatistics();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(MerchantStatistics merchantStatistics){
        return baseMapper.insert(merchantStatistics);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(MerchantStatistics merchantStatistics){
        return baseMapper.updateById(merchantStatistics);
    }

    @Override
    public MerchantStatistics findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<JlCount> bycount() {
        return baseMapper.bycount();
    }

    @Override
    public List<JLProportion> byTypesCount() {
        return baseMapper.byTypesCount();
    }
}
