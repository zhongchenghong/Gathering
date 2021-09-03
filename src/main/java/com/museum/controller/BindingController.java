package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IBindingService;
import com.museum.domain.Binding;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-28
 */
@Api(tags = {"同步账号绑定"})
@RestController
@RequestMapping("/binding")
public class BindingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBindingService bindingService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Binding binding){
        return bindingService.add(binding);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return bindingService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Binding binding){
        return bindingService.updateData(binding);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Binding> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return bindingService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Binding findById(@PathVariable Long id){
        return bindingService.findById(id);
    }

}
