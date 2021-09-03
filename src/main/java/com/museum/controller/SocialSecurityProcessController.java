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
import com.museum.service.ISocialSecurityProcessService;
import com.museum.domain.SocialSecurityProcess;
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
 * @since 2021-07-12
 */
@Api(tags = {"人力资源部---社保报销流程"})
@RestController
@RequestMapping("/social-security-process")
public class SocialSecurityProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ISocialSecurityProcessService socialSecurityProcessService;

    @Resource
    private IAccountService accountService;

    //文件地址
    @Value("${File}")
    private String File;


    @ApiOperation(value = "新增")
    @PostMapping()
    public Result add(String socialContent, String socialTitle, String socialType, HttpServletRequest req, MultipartFile file){

        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=accountService.getOne(queryWrapper);
        File fileSave=null;
        SocialSecurityProcess ss = new SocialSecurityProcess();
        if(file!=null){
            //获取文件后缀
            try {
                String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                // 重构文件名称
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
                String newVidoeName = pikId + "." + fileExt;
                fileSave = new File(File, newVidoeName);
                FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
                ss.setSocialFileName(file.getOriginalFilename());
                ss.setSocialPath(fileSave.getCanonicalPath());

            }catch (Exception e){
                return  ResultUtil.error(401,"发生为止错误");
            }
            ss.setSocialContent(socialContent);
            ss.setSocialTitle(socialTitle);
            ss.setSocialType(socialType);
            String date= SystemDateUtils.getStrDate();
            ss.setCreatetimes(date);
            socialSecurityProcessService.add(ss);
        }
        return ResultUtil.success("上传成功");
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return socialSecurityProcessService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody SocialSecurityProcess socialSecurityProcess){
        return socialSecurityProcessService.updateData(socialSecurityProcess);
    }

    /*@ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<SocialSecurityProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return socialSecurityProcessService.findListByPage(page, pageCount);
    }*/

  /*  @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public SocialSecurityProcess findById(@PathVariable Long id){
        return socialSecurityProcessService.findById(id);
    }
*/

    @ApiOperation(value = "通过标题查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/getbytitle")
    public IPage<SocialSecurityProcess> getbytitle(@RequestParam Integer page,
                                            @RequestParam Integer pageCount,String title){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.like("social_title",title);
        return socialSecurityProcessService.page(socialSecurityProcessService.findListByPage(page, pageCount),queryWrapper);

    }

}
