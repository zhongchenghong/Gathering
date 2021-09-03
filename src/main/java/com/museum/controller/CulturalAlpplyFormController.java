package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.domain.CulturalAlpplyFormList;
import com.museum.service.IAccountService;
import com.museum.service.ICulturalAlpplyListService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ICulturalAlpplyFormService;
import com.museum.domain.CulturalAlpplyForm;
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
 * 文创产品申请单 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Api(tags = {"文创产业----产品申请单"})
@RestController
@RequestMapping("/cultural-alpply-form")
public class CulturalAlpplyFormController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICulturalAlpplyFormService culturalAlpplyFormService;

    @Resource
    private IAccountService accountService;

    @Resource
    private ICulturalAlpplyListService culturalAlpplyListService;


    @ApiOperation(value = "新增文创产品申请单")
    @PostMapping("/add")
    public Result add(@RequestBody CulturalAlpplyFormList culturalAlpplyFormList, HttpServletRequest req){
        String str=SystemDateUtils.getStrDate();
        CulturalAlpplyForm culturalAlpplyForm = new CulturalAlpplyForm();
        culturalAlpplyForm.setUid(accountService.findAccount(req).getId());
        culturalAlpplyForm.setCreatetimes(str);
        culturalAlpplyForm.setApplytime(culturalAlpplyFormList.getApplytime());
        culturalAlpplyForm.setDepartment(culturalAlpplyFormList.getDepartment());
        culturalAlpplyForm.setRemarks(culturalAlpplyFormList.getRemarks());
        culturalAlpplyFormService.add(culturalAlpplyForm);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid", accountService.findAccount(req).getId());
        queryWrapper.eq("createtimes", str);
        CulturalAlpplyForm culturalAlpply=culturalAlpplyFormService.getOne(queryWrapper);
        for(int i=0;i<culturalAlpplyFormList.getList().size();i++){
            culturalAlpplyFormList.getList().get(i).setParentid(culturalAlpply.getId());
            culturalAlpplyListService.save(culturalAlpplyFormList.getList().get(i));

        }
        return ResultUtil.success();
    }

    @ApiOperation(value = "删除文创产品申请单")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return culturalAlpplyFormService.delete(id);
    }

    @ApiOperation(value = "更新文创产品申请单")
    @PutMapping()
    public int update(@RequestBody CulturalAlpplyForm culturalAlpplyForm){
        return culturalAlpplyFormService.updateData(culturalAlpplyForm);
    }

    @ApiOperation(value = "查询文创产品申请单分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<CulturalAlpplyForm> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return culturalAlpplyFormService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询文创产品申请单")
    @GetMapping("{id}")
    public CulturalAlpplyForm findById(@PathVariable Long id){
        return culturalAlpplyFormService.findById(id);
    }

}
