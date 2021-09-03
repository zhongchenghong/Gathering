package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Log.MyLog;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.politics.PoliticsWordInit;
import com.museum.common.politics.PoliticswordEngine;
import com.museum.common.sensitive.SensitiveWordInit;
import com.museum.common.sensitive.SensitivewordEngine;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.Screen;
import com.museum.service.*;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.domain.ScreenContent;
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
 * @since 2021-06-29
 */
@Api(tags = {"统一发布------大屏发布编辑"})
@RestController
@RequestMapping("/screen-content")
public class ScreenContentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAccountService accountService;

    @Resource
    private IScreenContentService screenContentService;

    @Resource
    private ISensitivesService sensitivesService;

    @Resource
    private IScreenService screenService;



    @ApiOperation(value = "大屏发布编辑")
    @PostMapping("/postcontent")
    @MyLog(value = "大屏发布编辑")
    public Result add(@RequestBody ScreenContent screenContent, HttpServletRequest req){
        SensitiveWordInit pwi= new SensitiveWordInit();
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=accountService.getOne(queryWrapper);
        String date=SystemDateUtils.getStrDate();
        screenContent.setCreatetimes(date);
        screenContent.setUid(bo.getId());
        //铭感字体过滤
        SensitivewordEngine.sensitiveWordMap= pwi.initKeyWord(sensitivesService.list());
        List<String> ls= SensitivewordEngine.getSensitiveWord(screenContent.getScreenContent(),2);
        if(SensitivewordEngine.isContaintSensitiveWord(screenContent.getScreenContent(),2)){
            return ResultUtil.error(401,"存在敏感字",ls);
        }
        screenContentService.add(screenContent);
        //大屏绑定
        Screen sc= screenService.findById(screenContent.getScreenId().longValue());
        QueryWrapper queryWrappers  = new QueryWrapper();
        queryWrappers.eq("createtimes",date);
        ScreenContent s = screenContentService.getOne(queryWrappers);
        sc.setScreenContentid(s.getId());
        screenService.updateById(sc);
        return ResultUtil.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return screenContentService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody ScreenContent screenContent){
        return screenContentService.updateData(screenContent);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ScreenContent> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return screenContentService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public ScreenContent findById(@PathVariable Long id){
        return screenContentService.findById(id);
    }

}
