package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IMaintainProcessService;
import com.museum.domain.MaintainProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 维护维修流程 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
@Api(tags = {"维护维修流程"})
@RestController
@RequestMapping("/maintain-process")
public class MaintainProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMaintainProcessService maintainProcessService;


    @ApiOperation(value = "新增维护维修流程")
    @PostMapping()
    public int add(@RequestBody MaintainProcess maintainProcess){
        return maintainProcessService.add(maintainProcess);
    }

    @ApiOperation(value = "删除维护维修流程")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return maintainProcessService.delete(id);
    }

    @ApiOperation(value = "更新维护维修流程")
    @PutMapping()
    public int update(@RequestBody MaintainProcess maintainProcess){
        return maintainProcessService.updateData(maintainProcess);
    }

    @ApiOperation(value = "查询维护维修流程分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<MaintainProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return maintainProcessService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询维护维修流程")
    @GetMapping("{id}")
    public MaintainProcess findById(@PathVariable Long id){
        return maintainProcessService.findById(id);
    }

}
