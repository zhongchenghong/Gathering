package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.ImageData;
import com.museum.service.IAccountService;
import com.museum.service.IImageDataService;
import com.museum.util.page.PageList;
import com.museum.util.page.PageListUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IAgentService;
import com.museum.domain.Agent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-05
 */
@Api(tags = {"待办事项"})
@RestController
@RequestMapping("/agent")
public class AgentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAgentService agentService;

    @Resource
    private IAccountService accountService;

    @Resource
    private IImageDataService imageDataService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Agent agent){
        return agentService.add(agent);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return agentService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Agent agent){
        return agentService.updateData(agent);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Agent> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,HttpServletRequest req){

        QueryWrapper queryWrappers = new QueryWrapper();
        //queryWrapper.eq("phone",phone);
        queryWrappers.eq("state", 2);
        queryWrappers.eq("uid",accountService.findAccount(req).getId());
        return agentService.page(agentService.findListByPage(page, pageCount),queryWrappers);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("/findById")
    public Object findById(Long id){
        ImageData im=null;
        Agent ag=agentService.findById(id);
        if(ag.getAgentType()==2){
         im= imageDataService.findById(Long.valueOf(ag.getImageDataId()));
            im.setName(ag.getSubmitname());
        }

            return im;
    }



    @ApiOperation(value = "查询列表")
    @GetMapping("/selectynlist")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    public PageList<Agent> selectynlist(HttpServletRequest req, @RequestParam Integer page,
                                         @RequestParam Integer pageCount, int state){
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrappers  = new QueryWrapper();
        queryWrappers.eq("userName",name);
        Account bo=accountService.getOne(queryWrappers);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("uid",bo.getId());
        queryWrapper.eq("state",state);
        queryWrapper.orderByDesc("createtimes");
        List<Agent> ages=agentService.list(queryWrapper);
        return PageListUtil.getPageList(ages.size(),page,ages,pageCount);

    }

}
