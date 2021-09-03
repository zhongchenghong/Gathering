package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IProductCatalogService;
import com.museum.domain.ProductCatalog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 文化公司驾驶舱-产品目录 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Api(tags = {"文化公司驾驶舱-产品目录"})
@RestController
@RequestMapping("/product-catalog")
public class ProductCatalogController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IProductCatalogService productCatalogService;


    @ApiOperation(value = "新增文化公司驾驶舱-产品目录")
    @PostMapping()
    public int add(@RequestBody ProductCatalog productCatalog){
        return productCatalogService.add(productCatalog);
    }

    @ApiOperation(value = "删除文化公司驾驶舱-产品目录")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return productCatalogService.delete(id);
    }

    @ApiOperation(value = "更新文化公司驾驶舱-产品目录")
    @PutMapping()
    public int update(@RequestBody ProductCatalog productCatalog){
        return productCatalogService.updateData(productCatalog);
    }

    @ApiOperation(value = "查询文化公司驾驶舱-产品目录分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ProductCatalog> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String name){
        QueryWrapper queryWrapper  = new QueryWrapper();
        if(name!=null&&!"".equals(name)){
            queryWrapper.like("name",name);
        }

        return productCatalogService.page(productCatalogService.findListByPage(page, pageCount),queryWrapper);

    }

    @ApiOperation(value = "id查询文化公司驾驶舱-产品目录")
    @GetMapping("{id}")
    public ProductCatalog findById(@PathVariable Long id){
        return productCatalogService.findById(id);
    }

}
