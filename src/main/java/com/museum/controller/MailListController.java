package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.AccountList;
import com.museum.domain.AccountMailList;
import com.museum.service.IAccountMailListService;
import com.museum.service.IAccountService;
import com.museum.service.impl.MailListServiceImpl;
import com.museum.util.SystemDateUtils;
import com.museum.util.page.PageList;
import com.museum.util.page.PageListUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IMailListService;
import com.museum.domain.MailList;
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
@Api(tags = {"通用功能------将用户添加到通讯录"})
@RestController
@RequestMapping("/maillist")
public class MailListController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMailListService mailListService;

    @Resource
    private MailListServiceImpl mailListServiceImpl;

    @Resource
    private IAccountService accountService;

    @Resource
    private IAccountMailListService accountMailListService;


    @ApiOperation(value = "将用户添加到通讯录")
    @PostMapping()
    public int add(@RequestBody MailList mailList, HttpServletRequest req){
        String date= SystemDateUtils.getStrDate();
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=accountService.getOne(queryWrapper);
        mailList.setCreatetimes(date);
        mailList.setUid(bo.getId());
        return mailListService.add(mailList);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){

        return mailListService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody MailList mailList){
        return mailListService.updateData(mailList);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<MailList> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return mailListService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "通讯录查询，传分组id-mailListId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/getmailList")
    public PageList<AccountList> findList(int mailid, HttpServletRequest req, @RequestParam Integer page,
                                          @RequestParam Integer pageCount){
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=accountService.getOne(queryWrapper);
        List<AccountList> users = mailListServiceImpl.accountList(mailid,bo.getId());
        PageList<AccountList> pageList = PageListUtil.getPageList(users.size(), page, users, pageCount);
        return pageList;

    }

    @ApiOperation(value = "通讯录查询，全部")
    @GetMapping("/getmailtotalList")
    public PageList<AccountList> findtotalList(String username, HttpServletRequest req,@RequestParam Integer page,
                                           @RequestParam Integer pageCount){
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=accountService.getOne(queryWrapper);
        List<AccountList> users = mailListServiceImpl.accounttotalList(username,bo.getId());
        PageList<AccountList> pageList = PageListUtil.getPageList(users.size(), page, users, pageCount);
        return pageList;
    }

}
