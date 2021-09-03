package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IRulesService;
import com.museum.domain.Rules;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-09
 */
@Api(tags = {"管理运营驾驶舱---规章制度"})
@RestController
@RequestMapping("/rules")
public class RulesController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRulesService rulesService;

    @Resource
    private IAccountService accountService;

    //文件地址
    @Value("${File}")
    private String File;


    @ApiOperation(value = "新增")
    @PostMapping()
    public Result add(Rules rules, MultipartFile file, HttpServletRequest req){
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=accountService.getOne(queryWrapper);
        File fileSave=null;
        if(file!=null){
            //获取文件后缀
            try {
                String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                // 重构文件名称
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
                String newVidoeName = pikId + "." + fileExt;
                fileSave = new File(File, newVidoeName);
                FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
                rules.setCreateTimes( SystemDateUtils.getStrDate());
                rules.setRulesFilename(file.getOriginalFilename());
                rules.setRulesAddress(fileSave.getCanonicalPath());

            }catch (Exception e){
                return  ResultUtil.error(401,"发生为止错误");
            }

        }
        rulesService.add(rules);
        return  ResultUtil.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return rulesService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Rules rules){
        return rulesService.updateData(rules);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Rules> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String title){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.like("rules_title",title);
        return rulesService.page(rulesService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Rules findById(@PathVariable Long id){
        return rulesService.findById(id);
    }

}
