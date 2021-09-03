package com.museum.controller;

import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IJlleaderService;
import com.museum.domain.Jlleader;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 锦里公司领导组件 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-11
 */
@Api(tags = {"锦里公司---领导组件"})
@RestController
@RequestMapping("/jlleader")
public class JlleaderController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IJlleaderService jlleaderService;


    @ApiOperation(value = "新增锦里公司领导组件")
    @PostMapping()
    public int add(@RequestBody Jlleader jlleader){
        jlleader.setCreatetime(SystemDateUtils.getStrDate());
        return jlleaderService.add(jlleader);
    }

    @ApiOperation(value = "删除锦里公司领导组件")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return jlleaderService.delete(id);
    }

    @ApiOperation(value = "更新锦里公司领导组件")
    @PutMapping()
    public int update(@RequestBody Jlleader jlleader){
        return jlleaderService.updateData(jlleader);
    }

    @ApiOperation(value = "查询锦里公司领导组件分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Jlleader> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return jlleaderService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询锦里公司领导组件")
    @GetMapping("{id}")
    public Jlleader findById(@PathVariable Long id){
        return jlleaderService.findById(id);
    }

}
