package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IPublisherAssemblyService;
import com.museum.domain.PublisherAssembly;
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
 * 发布者组件 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-10
 */
@Api(tags = {"发布者组件"})
@RestController
@RequestMapping("/publisher-assembly")
public class PublisherAssemblyController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPublisherAssemblyService publisherAssemblyService;


    @ApiOperation(value = "新增发布者组件")
    @PostMapping()
    public int add(@RequestBody PublisherAssembly publisherAssembly){
        return publisherAssemblyService.add(publisherAssembly);
    }

    @ApiOperation(value = "删除发布者组件")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return publisherAssemblyService.delete(id);
    }

    @ApiOperation(value = "更新发布者组件")
    @PutMapping()
    public int update(@RequestBody PublisherAssembly publisherAssembly){
        return publisherAssemblyService.updateData(publisherAssembly);
    }

    @ApiOperation(value = "查询发布者组件分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<PublisherAssembly> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return publisherAssemblyService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "查询发布者组件")
    @GetMapping("/publisherAssembly")
    public List<PublisherAssembly> findById(){

        return publisherAssemblyService.list();
    }

}
