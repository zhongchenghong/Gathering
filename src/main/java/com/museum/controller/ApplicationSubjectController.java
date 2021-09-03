package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IApplicationSubjectService;
import com.museum.domain.ApplicationSubject;
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
 * 财务部各个科目 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-16
 */
@Api(tags = {"财务部各个科目"})
@RestController
@RequestMapping("/application-subject")
public class ApplicationSubjectController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IApplicationSubjectService applicationSubjectService;


    @ApiOperation(value = "新增财务部各个科目")
    @PostMapping()
    public int add(@RequestBody ApplicationSubject applicationSubject){
        return applicationSubjectService.add(applicationSubject);
    }

    @ApiOperation(value = "删除财务部各个科目")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return applicationSubjectService.delete(id);
    }

    @ApiOperation(value = "更新财务部各个科目")
    @PutMapping()
    public int update(@RequestBody ApplicationSubject applicationSubject){
        return applicationSubjectService.updateData(applicationSubject);
    }


    @ApiOperation(value = "查询财务部各个科目")
    @GetMapping("{id}")
    public List<ApplicationSubject> findById()
    {
        return applicationSubjectService.list();
    }

}
