package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ICatalogueService;
import com.museum.domain.Catalogue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据中心-目录管理 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Api(tags = {"数据中心-目录管理"})
@RestController
@RequestMapping("/catalogue")
public class CatalogueController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICatalogueService catalogueService;


    @ApiOperation(value = "新增数据中心-目录管理")
    @PostMapping()
    public int add(@RequestBody Catalogue catalogue){
        return catalogueService.add(catalogue);
    }

    @ApiOperation(value = "删除数据中心-目录管理")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return catalogueService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-目录管理")
    @PutMapping()
    public int update(@RequestBody Catalogue catalogue){
        return catalogueService.updateData(catalogue);
    }

    @ApiOperation(value = "查询数据中心-目录管理分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Catalogue> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String name){
        QueryWrapper queryWrapper  = new QueryWrapper();

        if(name!=null&&!"".equals(name)){
            queryWrapper.like("name",name);
        }
        return catalogueService.page(catalogueService.findListByPage(page, pageCount),queryWrapper

        );
    }

    @ApiOperation(value = "id查询数据中心-目录管理")
    @GetMapping("{id}")
    public Catalogue findById(@PathVariable Long id){
        return catalogueService.findById(id);
    }

}
