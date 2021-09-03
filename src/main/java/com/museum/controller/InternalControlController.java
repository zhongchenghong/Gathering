package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.LegalKnowledge;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IInternalControlService;
import com.museum.domain.InternalControl;
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
@Api(tags = {"内控制度"})
@RestController
@RequestMapping("/internal-control")
public class InternalControlController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IInternalControlService internalControlService;

    @Resource
    private IAccountService accountService;

    //文件地址
    @Value("${File}")
    private String File;


    @ApiOperation(value = "新增")
    @PostMapping()
    public Result add(InternalControl internalControl, MultipartFile file, HttpServletRequest req){
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=accountService.getOne(queryWrapper);
        File fileSave=null;
        //保存文件
        if(file!=null){
            //获取文件后缀
            try {
                String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                // 重构文件名称
                String pikId = UUID.randomUUID().toString().replaceAll("-", "");
                String newVidoeName = pikId + "." + fileExt;
                fileSave = new File(File, newVidoeName);
                FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
                internalControl.setFileName(file.getOriginalFilename());
                internalControl.setFileAddress(fileSave.getCanonicalPath());

            }catch (Exception e){
                return  ResultUtil.error(401,"发生为止错误");
            }

        }
        internalControl.setCreatetimes(SystemDateUtils.getStrDate());
        internalControlService.add(internalControl);
        return   ResultUtil.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return internalControlService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody InternalControl internalControl){
        return internalControlService.updateData(internalControl);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<InternalControl> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String title){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.like("institution_title",title);
        return internalControlService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public InternalControl findById(@PathVariable Long id){
        return internalControlService.findById(id);
    }

}
