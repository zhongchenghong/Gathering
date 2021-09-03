package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IProcessFormService;
import com.museum.domain.ProcessForm;
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
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-28
 */
@Api(tags = {"通用功能----流程申请表单"})
@RestController
@RequestMapping("/process-form")
public class ProcessFormController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IProcessFormService processFormService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody ProcessForm processForm){
        return processFormService.add(processForm);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return processFormService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody ProcessForm processForm){
        return processFormService.updateData(processForm);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ProcessForm> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return processFormService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "查询申请表单列表")
    @PostMapping("/getList")
    public List<ProcessForm> findById(int departmentId, String name){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.like("name",name);
        if(!"".equals(String.valueOf(departmentId)) ||!"null".equals(String.valueOf(departmentId)) || departmentId >=0)
        {

            queryWrapper.eq("departmentId",departmentId);
        }
        return processFormService.list(queryWrapper);

    }

}
