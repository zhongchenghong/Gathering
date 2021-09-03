package com.museum.controller;

import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ICulturalTourismService;
import com.museum.domain.CulturalTourism;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据中心-文旅数据上报 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Api(tags = {"数据中心-文旅数据上报"})
@RestController
@RequestMapping("/cultural-tourism")
public class CulturalTourismController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICulturalTourismService culturalTourismService;

    @Resource
    private IAccountService accountService;

    @ApiOperation(value = "新增数据中心-文旅数据上报")
    @PostMapping()
    public int add(@RequestBody CulturalTourism culturalTourism, HttpServletRequest req){
        Account acc= accountService.findAccount(req);
        culturalTourism.setUid(acc.getId());
        culturalTourism.setCreatetime(SystemDateUtils.getStrDate());
        return culturalTourismService.add(culturalTourism);
    }

    @ApiOperation(value = "删除数据中心-文旅数据上报")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return culturalTourismService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-文旅数据上报")
    @PutMapping()
    public int update(@RequestBody CulturalTourism culturalTourism){
        return culturalTourismService.updateData(culturalTourism);
    }

    @ApiOperation(value = "查询数据中心-文旅数据上报分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<CulturalTourism> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return culturalTourismService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询数据中心-文旅数据上报")
    @GetMapping("{id}")
    public CulturalTourism findById(@PathVariable Long id){
        return culturalTourismService.findById(id);
    }

}
