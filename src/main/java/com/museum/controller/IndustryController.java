package com.museum.controller;

import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IIndustryService;
import com.museum.domain.Industry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 文创产业部产业添加 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Api(tags = {"文创产业部----产业添加"})
@RestController
@RequestMapping("/industry")
public class IndustryController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAccountService accountService;

    @Resource
    private IIndustryService industryService;


    @ApiOperation(value = "新增文创产业部产业添加")
    @PostMapping()
    public int add(@RequestBody Industry industry, HttpServletRequest req){
       Account acc=accountService.findAccount(req);
        industry.setCreatetimes(SystemDateUtils.getStrDate());
        industry.setUid(acc.getId());
        return industryService.add(industry);
    }
    @ApiOperation(value = "删除文创产业部产业添加")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return industryService.delete(id);
    }

    @ApiOperation(value = "更新文创产业部产业添加")
    @PutMapping()
    public int update(@RequestBody Industry industry){
        return industryService.updateData(industry);
    }

    @ApiOperation(value = "查询文创产业部产业添加分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Industry> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return industryService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询文创产业部产业添加")
    @GetMapping("{id}")
    public Industry findById(@PathVariable Long id){
        return industryService.findById(id);
    }

}
