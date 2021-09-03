package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.INoticeService;
import com.museum.domain.Notice;
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
 * @since 2021-07-14
 */
@Api(tags = {"通用功能----通知公告"})
@RestController
@RequestMapping("/notice")
public class NoticeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private INoticeService noticeService;


    @ApiOperation(value = "新增通知公告")
    @PostMapping()
    public int add(@RequestBody Notice notice){
        return noticeService.add(notice);
    }

    @ApiOperation(value = "删除通知公告")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return noticeService.delete(id);
    }

    @ApiOperation(value = "更新通知公告")
    @PutMapping()
    public int update(@RequestBody Notice notice){
        return noticeService.updateData(notice);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Notice> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return noticeService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询通知公告")
    @GetMapping("{id}")
    public Notice findById(@PathVariable Long id){
        return noticeService.findById(id);
    }

}
