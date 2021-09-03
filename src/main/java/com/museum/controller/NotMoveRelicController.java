package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.INotMoveRelicService;
import com.museum.domain.NotMoveRelic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据中心-不可移动文物 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Api(tags = {"数据中心-不可移动文物"})
@RestController
@RequestMapping("/not-move-relic")
public class NotMoveRelicController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private INotMoveRelicService notMoveRelicService;


    @ApiOperation(value = "新增数据中心-不可移动文物")
    @PostMapping()
    public int add(@RequestBody NotMoveRelic notMoveRelic){
        return notMoveRelicService.add(notMoveRelic);
    }

    @ApiOperation(value = "删除数据中心-不可移动文物")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return notMoveRelicService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-不可移动文物")
    @PutMapping()
    public int update(@RequestBody NotMoveRelic notMoveRelic){
        return notMoveRelicService.updateData(notMoveRelic);
    }

    @ApiOperation(value = "查询数据中心-不可移动文物分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<NotMoveRelic> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String name){
        QueryWrapper queryWrappers  = new QueryWrapper();
        queryWrappers.eq("name",name);
        return notMoveRelicService.page(notMoveRelicService.findListByPage(page, pageCount),queryWrappers);
    }

    @ApiOperation(value = "id查询数据中心-不可移动文物")
    @GetMapping("{id}")
    public NotMoveRelic findById(@PathVariable Long id){
        return notMoveRelicService.findById(id);
    }

}
