package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ITicketTypeService;
import com.museum.domain.TicketType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 财务票价类型 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-13
 */
@Api(tags = {"财务票价类型"})
@RestController
@RequestMapping("/ticket-type")
public class TicketTypeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ITicketTypeService ticketTypeService;


    @ApiOperation(value = "新增财务票价类型")
    @PostMapping()
    public int add(@RequestBody TicketType ticketType){
        return ticketTypeService.add(ticketType);
    }

    @ApiOperation(value = "删除财务票价类型")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return ticketTypeService.delete(id);
    }

    @ApiOperation(value = "更新财务票价类型")
    @PutMapping()
    public int update(@RequestBody TicketType ticketType){
        return ticketTypeService.updateData(ticketType);
    }

    @ApiOperation(value = "查询财务票价类型分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<TicketType> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return ticketTypeService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询财务票价类型")
    @GetMapping("{id}")
    public TicketType findById(@PathVariable Long id){
        return ticketTypeService.findById(id);
    }

}
