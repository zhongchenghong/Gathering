package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.common.shortmessage.PasswordCode;
import com.museum.common.shortmessage.SendCode;
import com.museum.domain.*;
import com.museum.service.IBindingService;
import com.museum.service.IDepartmentService;
import com.museum.service.IPositionService;
import com.museum.util.Localmac;
import com.museum.util.RandomStringUtil;
import com.museum.util.SystemDateUtils;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-05-25
 */
@Api(tags = {"用户登录"})
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/account")
public class AccountController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAccountService accountService;

    @Resource
    private IBindingService bindingService;

    @Resource
    private IDepartmentService departmentService;

    @Resource
    private IPositionService positionService;


    @ApiOperation(value = "账号密码登录")
    @PostMapping(value = "/login")
    public Result login(@RequestBody Account u, HttpServletRequest req) {
        // 获取当前用户主体
        String msg = null;
        String password = new SimpleHash("SHA-1", u.getPassword(), u.getUserName(), 16).toString();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userName", u.getUserName());
        queryWrapper.eq("password", password);
        Account bo = accountService.getOne(queryWrapper);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = SystemDateUtils.getStrDate();
        try {
            if (sdf.parse(bo.getExpirationTime()).compareTo(sdf.parse(currentTime)) < 0) {
                return ResultUtil.error(401, "账户过期了");
            }
        } catch (Exception e) {
            System.out.println("");
        }

        //获取mac地址

        try {
            Assert.notNull(bo, "用户名或密码错误");
            String token = null;
            token = JWTUtil.createToken(bo);
            /* if(!bo.getMacid().equals(u.getMacid())){
                return ResultUtil.error(202,bo.getPhone());
            }else {

            }*/
            Department de=departmentService.findById(Long.valueOf(bo.getDepartmentId()));
            Position po=positionService.findById(Long.valueOf(bo.getPositionId()));
            AccountToken at= new AccountToken();
            at.setToken(token);
            at.setName(bo.getName());
            at.setDepartment(de.getDepartmentName());
            at.setEmail(bo.getEmail());
            at.setPhone(bo.getPhone());
            at.setPosition(po.getPositionName());
            at.setUserName(bo.getUserName());
            return ResultUtil.success(at);

        } catch (IllegalArgumentException e) {
            return ResultUtil.error(401, "用户名或密码错误");
        }

    }


    @ApiOperation(value = "发送短信验证")
    @PostMapping(value = "/codesend")
    public Result VerificationCode(@RequestBody String phone) {
        try {
            QueryWrapper queryWrappers = new QueryWrapper();
            //queryWrapper.eq("phone",phone);
            queryWrappers.eq("phone", phone);
            Account bo = accountService.getOne(queryWrappers);
            //设置日期格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Assert.notNull(bo, "手机号不存在");
            String currentTime = SystemDateUtils.getStrDate();
            try {
                if (df.parse(bo.getExpirationTime()).compareTo(df.parse(currentTime)) < 0) {
                    return ResultUtil.error(401, "账户过期了");
                }
            } catch (Exception e) {
                System.out.println("");
            }
            //第一次发短信验证码
            if (bo != null && (bo.getCodecreatetime() == null || "".equals(bo.getCodecreatetime()))) {
                String num = SendCode.sendCode(phone);
                bo.setCode(num);
                bo.setCodecreatetime(df.format(new Date()));
                accountService.updateData(bo);
                return ResultUtil.success("发送成功");
                //多次发短信验证码
            } else if (bo != null) {
                Date afterDate = new Date(new Date().getTime() - 300000);
                Date sd1 = df.parse(df.format(afterDate));
                Date sd2 = df.parse(bo.getCodecreatetime());
                if (sd1.after(sd2)) {
                    String num = SendCode.sendCode(phone);
                    bo.setCode(num);
                    bo.setCodecreatetime(df.format(new Date()));
                    accountService.updateData(bo);
                    return ResultUtil.success("发送成功");
                } else {
                    return ResultUtil.error(401, "短信5分钟内有效，不能多次发送");
                }

            } else {
                return ResultUtil.error(401, "手机号不存在");
            }
        } catch (IOException e) {
            return ResultUtil.error(401, "短信发送失败");
        } catch (IllegalArgumentException e) {
            return ResultUtil.error(401, "手机号不存在");
        } catch (ParseException e) {
            return ResultUtil.error(401, "时间格式错误");
        }
    }

    @ApiOperation(value = "短信验证登录")
    @PostMapping(value = "/codelogin")
    public Result CodeLogib(@RequestBody String code,String phone) {
        try {
            QueryWrapper queryWrappers = new QueryWrapper();
            queryWrappers.eq("phone",phone);
            queryWrappers.eq("code", code);
            Account bo = accountService.getOne(queryWrappers);
            Assert.notNull(bo, "验证码错误");
            //设置日期格式
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date afterDate = new Date(new Date().getTime() - 300000);
            Date sd1 = df.parse(df.format(afterDate));
            Date sd2 = df.parse(bo.getCodecreatetime());
            String token = null;
            token = JWTUtil.createToken(bo);
            if (sd1.after(sd2)) {
                return ResultUtil.error(401, "验证码过期，请重新获取");
            } else {
                bo.setCode("");
                accountService.updateData(bo);
                return ResultUtil.success(token);
            }

        } catch (IllegalArgumentException e) {
            return ResultUtil.error(401, "验证码错误");
        } catch (ParseException e) {
            return ResultUtil.error(401, "时间格式错误");
        }

    }


    @ApiOperation(value = "添加账号")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody Account u, HttpServletRequest req) {
        String password = new SimpleHash("SHA-1", u.getPassword(), u.getUserName(), 16).toString();
        QueryWrapper queryWrappers = new QueryWrapper();
        queryWrappers.eq("userName", u.getUserName());
        Account bo = accountService.getOne(queryWrappers);
        if(bo!=null){
            return ResultUtil.error(401,"账号已存在");
        }else{
            u.setPassword(password);
            accountService.add(u);
        }

        return ResultUtil.success();
    }
/*
    @ApiOperation(value = "退出")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return ResultUtil.success("");
    }
*/

    @ApiOperation(value = "账户密码下发")
    @PostMapping(value = "/sendpassword")
    public Result sendpassword(@RequestBody String phone) {
        try {
            QueryWrapper queryWrappers = new QueryWrapper();
            queryWrappers.eq("phone", phone);
            Account bo = accountService.getOne(queryWrappers);
            Assert.notNull(bo, "手机号不存在");
            String str = RandomStringUtil.getRandomCode(10, 6);
            System.out.println("密码为" + str);
            String password = new SimpleHash("SHA-1", str, bo.getUserName(), 16).toString();
            bo.setPassword(password);
            accountService.updateData(bo);
            PasswordCode.sendCode(bo.getPhone(), bo.getUserName(), str);
            return ResultUtil.success("下发成功");
        } catch (IllegalArgumentException | IOException e) {
            return ResultUtil.error(401, "手机号不存在");
        }

    }

    @ApiOperation(value = "用户模糊查询")
    @PostMapping(value = "/selectuser")
    public Result selectUser(@RequestBody String name) {
        List<Account> bo = null;
        if (!"".equals(name) || name != null) {
            QueryWrapper queryWrappers = new QueryWrapper();
            queryWrappers.like("userName", name);
            bo = accountService.list(queryWrappers);
            return ResultUtil.success(bo);
        } else {
            return ResultUtil.error(401, "用户找不到");
        }

    }

    @ApiOperation(value = "修改密码")
    @PostMapping(value = "/updatepassword")
    public Result updatePassword(HttpServletRequest req, String newpasswor, String oldpassword) {
        String token = req.getHeader("token");
        String name = JWTUtil.getUsername(token);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userName", name);
        Account bo = accountService.getOne(queryWrapper);
        String password = new SimpleHash("SHA-1", oldpassword, bo.getUserName(), 16).toString();
        String oldpasswords = new SimpleHash("SHA-1", newpasswor, bo.getUserName(), 16).toString();
        if (password.equals(bo.getPassword())) {
            bo.setPassword(oldpasswords);
            accountService.updateData(bo);
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.error(401, "原始密码错误");
        }


    }

    @ApiOperation(value = "密码重置")
    @PostMapping(value = "/resetpassword")
    public Result resetPassword(HttpServletRequest req, Long id) {
        if (!"".equals(id)) {
            Account bo = accountService.findById(id);
            String password = new SimpleHash("SHA-1", "123456", bo.getUserName(), 16).toString();
            bo.setPassword(password);
            accountService.updateData(bo);
            return ResultUtil.success("重置成功");
        } else {
            String token = req.getHeader("token");
            String name = JWTUtil.getUsername(token);
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("userName", name);
            Account bo = accountService.getOne(queryWrapper);
            String password = new SimpleHash("SHA-1", "123456", bo.getUserName(), 16).toString();
            bo.setPassword(password);
            accountService.updateData(bo);
            return ResultUtil.success("重置成功");
        }


    }

    @ApiOperation(value = "excel导出")
    @PostMapping(value = "/exceluser")
    public void excelUser(String name,String departmentId,String positionId, HttpServletResponse response, HttpServletRequest request) {
        List<Account> list = null;
        QueryWrapper queryWrappers = new QueryWrapper();
        if(name!=null&&!"".equals(name)){
            queryWrappers.like("userName", name);
        }
        if(departmentId!=null&&!"".equals(departmentId)){
            queryWrappers.eq("department_id", departmentId);
        }
        if(positionId!=null&&!"".equals(positionId)){
            queryWrappers.eq("position_id", positionId);
        }
        list = accountService.list(queryWrappers);

        HSSFWorkbook workbook = accountService.createContractExcel(list);
        // 设置要导出的文件的名字
        String fileName = "用户信息表"  + new Date() + ".xls";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 查询用户列表
     * @param page
     * @param pageCount
     * @param u
     * @return
     */
    @GetMapping("/getpage")
    @ApiOperation(value = "查询用户列表")
    public IPage<User> findListByPage(@RequestParam Integer page,
                                      @RequestParam Integer pageCount, Account u){
        QueryWrapper queryWrapp = new QueryWrapper();
        if(u!=null&&!"".equals(u.getUserName())){
            queryWrapp.like("userName",u.getUserName());

        }
        if(u!=null&&!"".equals(u.getPhone())){
            queryWrapp.like("phone",u.getPhone());
        }
        if(u!=null&&!"".equals(u.getCreatetimes())){
            queryWrapp.orderByAsc("creatdate",u.getCreatetimes());
        }

        return accountService.page(accountService.findListByPage(page, pageCount),queryWrapp);

    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody  Account u){
        return accountService.updateData(u);
    }


    /**
     * 单点登录账户绑定
     * @return
     */
    @GetMapping("/binding")
    @ApiOperation(value = "单点登录账户绑定")
    public Result binding(Binding binding){
        binding.setCreatetime(SystemDateUtils.getStrDate());
        bindingService.add(binding);
        return  ResultUtil.success("绑定成功");
    }


}