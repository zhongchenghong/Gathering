package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IAncientArchitectureService;
import com.museum.domain.AncientArchitecture;
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
 * 数据中心-古建数据 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Api(tags = {"数据中心-古建数据"})
@RestController
@RequestMapping("/ancient-architecture")
public class AncientArchitectureController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAncientArchitectureService ancientArchitectureService;
    @Resource
    private IAccountService accountService;


    @ApiOperation(value = "新增数据中心-古建数据")
    @PostMapping()
    public int add(@RequestBody AncientArchitecture ancientArchitecture, HttpServletRequest req){
        ancientArchitecture.setUid(accountService.findAccount(req).getId());
        ancientArchitecture.setCreatimes(SystemDateUtils.getStrDate());
        return ancientArchitectureService.add(ancientArchitecture);
    }

    @ApiOperation(value = "删除数据中心-古建数据")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return ancientArchitectureService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-古建数据")
    @PutMapping()
    public int update(@RequestBody AncientArchitecture ancientArchitecture){
        return ancientArchitectureService.updateData(ancientArchitecture);
    }

    @ApiOperation(value = "查询数据中心-古建数据分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<AncientArchitecture> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String name){
        QueryWrapper queryWrapper  = new QueryWrapper();
        if(name!=null&&!"".equals(name)){
            queryWrapper.eq("name",name);
        }

        return ancientArchitectureService.page(ancientArchitectureService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询数据中心-古建数据")
    @GetMapping("{id}")
    public AncientArchitecture findById(@PathVariable Long id){
        return ancientArchitectureService.findById(id);
    }

}
