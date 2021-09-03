package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IVisitsNameService;
import com.museum.domain.VisitsName;
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
 * @since 2021-07-15
 */
@Api(tags = {"访问统计----各网站名称表"})
@RestController
@RequestMapping("/visits-name")
public class VisitsNameController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IVisitsNameService visitsNameService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody VisitsName visitsName){
        return visitsNameService.add(visitsName);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return visitsNameService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody VisitsName visitsName){
        return visitsNameService.updateData(visitsName);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<VisitsName> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return visitsNameService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public VisitsName findById(@PathVariable Long id){
        return visitsNameService.findById(id);
    }

}
