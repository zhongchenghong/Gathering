package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.domain.Account;
import com.museum.service.IAccountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IProceduresService;
import com.museum.domain.Procedures;
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
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-20
 */
@Api(tags = {"通用功能----我的流程"})
@RestController
@RequestMapping("/procedures")
public class ProceduresController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IProceduresService proceduresService;

    @Resource
    private IAccountService accountService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Procedures procedures){
        return proceduresService.add(procedures);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return proceduresService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Procedures procedures){
        return proceduresService.updateData(procedures);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Procedures> findListByPage(@RequestParam Integer page,
                                            @RequestParam Integer pageCount, int state, String name, HttpServletRequest req){
        Account ac=accountService.findAccount(req);
        QueryWrapper queryWrappers  = new QueryWrapper();
        if(name!=null&&!"".equals(name)){
            queryWrappers.like("apply_type",name);
        }

        if(state==3){
        }else{
            queryWrappers.eq("state",state);
        }
            queryWrappers.eq("uid",ac.getId());
            queryWrappers.select().orderByDesc("apply_time");
       return  proceduresService.page(proceduresService.findListByPage(page, pageCount),queryWrappers);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("/findById")
    public Procedures findById(@PathVariable Long id){
        return proceduresService.findById(id);
    }

}
