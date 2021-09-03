package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.service.IMailListService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IAccountMailListService;
import com.museum.domain.AccountMailList;
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
 * @since 2021-07-01
 */
@Api(tags = {"通讯录分组管理"})
@RestController
@RequestMapping("/account-mail-list")
public class AccountMailListController {

    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private IAccountService accountService;

    @Resource
    private IAccountMailListService accountMailListService;

    @Resource
    private IMailListService mailListService;


    @ApiOperation(value = "新增分组")
    @PostMapping()
    public Result add(@RequestBody AccountMailList accountMailList, HttpServletRequest req){
        String date=SystemDateUtils.getStrDate();
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=accountService.getOne(queryWrapper);
        accountMailList.setUid(bo.getId());
        accountMailList.setCreatetimes(date);
        //去掉重名分组
        QueryWrapper queryWrappera  = new QueryWrapper();
        queryWrappera.eq("userName",accountMailList.getMailListName());
        AccountMailList AC=accountMailListService.getOne(queryWrappera);
        if(AC==null||"".equals(AC)){
            return ResultUtil.success(accountMailListService.add(accountMailList));
        }else{
            return ResultUtil.error(401,"分组已存在");
        }

    }

    @ApiOperation(value = "删除分组")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        QueryWrapper queryWrappera  = new QueryWrapper();
        queryWrappera.eq("mail_list_id",id);
        mailListService.remove(queryWrappera);
        return accountMailListService.delete(id);
    }

    @ApiOperation(value = "编辑成功")
    @PutMapping()
    public Result update(@RequestBody AccountMailList accountMailList){
        //去掉重名分组
        QueryWrapper queryWrappera  = new QueryWrapper();
        queryWrappera.eq("userName",accountMailList.getMailListName());
        AccountMailList AC=accountMailListService.getOne(queryWrappera);
        if(AC!=null||!"".equals(AC)){
            accountMailListService.updateData(accountMailList);
            return ResultUtil.success("编辑成功");
        }else{
            return ResultUtil.error(401,"编辑失败");
        }

    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<AccountMailList> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return accountMailListService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "遍历分组")
    @GetMapping("/getListMail")
    public List<AccountMailList> findById(HttpServletRequest req){
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=accountService.getOne(queryWrapper);
        return accountMailListService.list();
    }

/*
    @ApiOperation(value = "查询分组下的人")
    @GetMapping("/getgrouplist")
    public List<AccountMailList> getGroupList(String id,HttpServletRequest req){

    }
*/

}
