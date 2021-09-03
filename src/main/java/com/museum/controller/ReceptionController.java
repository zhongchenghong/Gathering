package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IReceptionService;
import com.museum.domain.Reception;
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
 * @since 2021-07-21
 */
@Api(tags = {"办公室-----日常接待申请单"})
@RestController
@RequestMapping("/reception")
public class ReceptionController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IReceptionService receptionService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Reception reception){
        return receptionService.add(reception);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return receptionService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Reception reception){
        return receptionService.updateData(reception);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Reception> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return receptionService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Reception findById(@PathVariable Long id){
        return receptionService.findById(id);
    }

}
