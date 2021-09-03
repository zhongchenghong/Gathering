package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IPostFormService;
import com.museum.domain.PostForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 发文申请 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-21
 */
@Api(tags = {"发文申请"})
@RestController
@RequestMapping("/post-form")
public class PostFormController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPostFormService postFormService;


    @ApiOperation(value = "新增发文申请")
    @PostMapping()
    public int add(@RequestBody PostForm postForm){
        return postFormService.add(postForm);
    }

    @ApiOperation(value = "删除发文申请")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return postFormService.delete(id);
    }

    @ApiOperation(value = "更新发文申请")
    @PutMapping()
    public int update(@RequestBody PostForm postForm){
        return postFormService.updateData(postForm);
    }

    @ApiOperation(value = "查询发文申请分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<PostForm> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return postFormService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询发文申请")
    @GetMapping("{id}")
    public PostForm findById(@PathVariable Long id){
        return postFormService.findById(id);
    }

}
