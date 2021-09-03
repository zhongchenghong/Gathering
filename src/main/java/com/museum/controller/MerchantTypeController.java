package com.museum.controller;

import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IMerchantTypeService;
import com.museum.domain.MerchantType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
@Api(tags = {"锦里公司-----类型组件"})
@RestController
@RequestMapping("/merchant-type")
public class MerchantTypeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMerchantTypeService merchantTypeService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody MerchantType merchantType){
        merchantType.setCreatetimes(SystemDateUtils.getStrDate());

        return merchantTypeService.add(merchantType);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return merchantTypeService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody MerchantType merchantType){
        return merchantTypeService.updateData(merchantType);
    }

    @ApiOperation(value = "查询锦里公司商户类型列表")
    @GetMapping("/findList")
    public List<MerchantType> findList(){
        return merchantTypeService.list();
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public MerchantType findById(@PathVariable Long id){
        return merchantTypeService.findById(id);
    }

}
