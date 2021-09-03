package com.museum.controller;

import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IVisitsService;
import com.museum.domain.Visits;
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
@Api(tags = {"官网------各网站年月日访问量表"})
@RestController
@RequestMapping("/visits")
public class VisitsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IVisitsService visitsService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Visits visits){
        visits.setCreateTime(SystemDateUtils.getStrDate());
        return visitsService.add(visits);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return visitsService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Visits visits){
        return visitsService.updateData(visits);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Visits> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return visitsService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Visits findById(@PathVariable Long id){
        return visitsService.findById(id);
    }

}
