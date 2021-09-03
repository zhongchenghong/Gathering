package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.domain.Authentication;
import com.museum.domain.UserSystem;
import com.museum.domain.Users;
import com.museum.service.IAuthenticationService;
import com.museum.service.IUserSystemService;
import com.museum.util.Md5;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IUserService;
import com.museum.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-05-17
 * 同步用户
 */
@Api(tags = {"4a----用户同步"})
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService userService;

    @Resource
    private IAuthenticationService authenticationService;
    //可单点登陆的系统
    @Resource
    private IUserSystemService userSystemService;

    @ApiOperation(value = "同步用户")
    @PostMapping("/synchronize")
    public Result add(Users users){
        User us=null;
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("only_sum",users.getSystemName());
        Authentication authentication=authenticationService.getOne(queryWrapper);

        int sum=0;
        if(authentication!=null){
            try {
                QueryWrapper queryWrappers  = new QueryWrapper();
                queryWrappers.eq("account",users.getAccount());
                queryWrappers.eq("authentication_id",authentication.getId());
                us=userService.getOne(queryWrappers);
                if(us!=null){
                    //用户存在更新
                    userService.saveOrUpdate(us);
                    sum++;
                }else{
                    User user = new User();
                    user.setPassword(users.getPassword());
                    user.setAccount(users.getAccount());
                    user.setCreatdate(new Date());
                    user.setPhone(users.getPhone());
                    user.setAuthenticationId(authentication.getId());
                    userService.saveOrUpdate(user);

                    //可单点登录的系统
                    UserSystem usy = new UserSystem();
                    QueryWrapper queryWrapp = new QueryWrapper();
                    queryWrapp.eq("account",users.getAccount());
                    queryWrapp.eq("authentication_id",authentication.getId());
                    us=userService.getOne(queryWrapp);
                    String date=SystemDateUtils.getStrDate();
                    usy.setSystemId(authentication.getId());
                    usy.setUserId(us.getId());
                    usy.setCreatetimes(date);
                    userSystemService.save(usy);
                    sum++;
                }

            }catch (Exception e){
                e.printStackTrace();
                return ResultUtil.error(500,e.getMessage());
            }
            return ResultUtil.success("同步成功"+sum);
        }
        return ResultUtil.error(405,"系统未注册");
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return userService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody User user){
        return userService.updateData(user);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<User> findListByPage(@RequestParam Integer page,
                                      @RequestParam Integer pageCount,User user){
        QueryWrapper queryWrapp = new QueryWrapper();
        if(user!=null&&!"".equals(user.getAccount())){
            queryWrapp.like("account",user.getAccount());

        }
        if(user!=null&&!"".equals(user.getPhone())){
            queryWrapp.like("phone",user.getPhone());
        }
        if(user!=null&&!"".equals(user.getPhone())){
            queryWrapp.orderByAsc("creatdate",user.getCreatdate());
        }

        return userService.page(userService.findListByPage(page, pageCount),queryWrapp);

    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

}
