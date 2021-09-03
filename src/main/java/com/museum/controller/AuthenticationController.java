package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Log.MyLog;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.domain.User;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IAuthenticationService;
import com.museum.domain.Authentication;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-05-17
 * 注册系统
 * 注册成功，才可以同步账号
 */
@Api(tags = {"注册系统"})
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/authentication")
public class AuthenticationController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAuthenticationService authenticationService;


    @ApiOperation(value = "注册系统")
    @PostMapping("/insertsystem")
    @MyLog(value = "注册系统")
    public Result add(@RequestBody Authentication authentication){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("sysname",authentication.getSysname());
        String onlysum = new SimpleHash( "SHA-1", "123456", authentication.getSysname(), 16).toString();
        Authentication bo=authenticationService.getOne(queryWrapper);
        if(bo!=null){
            authenticationService.saveOrUpdate(bo);
            return ResultUtil.error(401,"系统已存在");
        }else{
            String daDate = SystemDateUtils.getStrDate();
            authentication.setTimes(daDate);
            authentication.setOnlySum(onlysum);
            authenticationService.saveOrUpdate(authentication);
            return ResultUtil.success();
        }


    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return authenticationService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Authentication authentication){
        return authenticationService.updateData(authentication);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Authentication> findListByPage(@RequestParam Integer page,
                                                @RequestParam Integer pageCount){
        return authenticationService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Authentication findById(@PathVariable Long id){
        return authenticationService.findById(id);
    }

}
