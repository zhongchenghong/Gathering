package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.HttpRequest;
import com.museum.domain.*;
import com.museum.service.*;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 单点登录
 */
@Api(tags = {"4a-----单点登录"})
@Controller
@RequestMapping("/login")
public class SingleLoginController {
    @Resource
    private IAuthenticationService authenticationService;

    @Resource
    private IAccountService accountService;

    @Resource
    private IBindingService bindingService;

    @Resource
    private IUserService userService;

    @Value("${protect}")
    private String protect;



    @ApiOperation(value = "保护信息管理系统单点登录")
    @PostMapping("/jup")
    @ResponseBody
    public Protectinformation getToken(HttpServletRequest req){
       Protectinformation pf = new Protectinformation();
       Account ac=accountService.findAccount(req);
       QueryWrapper queryWrapp = new QueryWrapper();
       queryWrapp.eq("uid",ac.getId());
       queryWrapp.eq("authenticationid",40);
       Binding binding=bindingService.getOne(queryWrapp);
       User user=userService.findById(binding.getUserid().longValue());
       Authentication authentication=authenticationService.findById(40L);
       String dateStr = Long.toString(System.currentTimeMillis()/1000L);
       String str=DigestUtils.md5DigestAsHex((protect+dateStr).getBytes());
       pf.setUrl(authentication.getSystemUrl());
       pf.setSignature(str);
       pf.setTimestamp(dateStr);
       pf.setUsername(user.getAccount());
       return pf;

    }
}
