package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.ScreenResources;
import com.museum.service.IAccountService;
import com.museum.util.HttpContextUtil;
import com.museum.util.SystemDateUtils;
import com.museum.util.WangEditor;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IComplaintFormService;
import com.museum.domain.ComplaintForm;
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
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 投诉处理表单 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-21
 */
@Api(tags = {"办公室驾---投诉处理表单"})
@RestController
@RequestMapping("/complaint-form")
public class ComplaintFormController {

    //文件地址
    @Value("${File}")
    private String File;

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IComplaintFormService complaintFormService;

    @Resource
    private IAccountService accountService;


    @ApiOperation(value = "新增投诉处理表单")
    @PostMapping()
    public Result add(@RequestBody ComplaintForm complaintForm, MultipartFile file){

        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件

            File fileSave = new File(File, newVidoeName);
            FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
            HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
            String token=request.getHeader("token");
            String name= JWTUtil.getUsername(token);
            QueryWrapper queryWrapper  = new QueryWrapper();
            queryWrapper.eq("userName",name);
            //获取用户名
            Account acc=accountService.getOne(queryWrapper);
            complaintForm.setPath(File);
            complaintForm.setCreatetime(SystemDateUtils.getStrDate());
            complaintForm.setOriginalfilename(file.getOriginalFilename());
            complaintForm.setPath(fileSave.getCanonicalPath());
            complaintForm.setUid(acc.getId());
            complaintFormService.add(complaintForm);
            return ResultUtil.success();

        }catch (Exception e){
            return ResultUtil.error(401,"上传失败");

        }

    }

    @ApiOperation(value = "删除投诉处理表单")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return complaintFormService.delete(id);
    }

    @ApiOperation(value = "更新投诉处理表单")
    @PutMapping()
    public int update(@RequestBody ComplaintForm complaintForm){
        return complaintFormService.updateData(complaintForm);
    }

    @ApiOperation(value = "查询投诉处理表单分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ComplaintForm> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return complaintFormService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询投诉处理表单")
    @GetMapping("{id}")
    public ComplaintForm findById(@PathVariable Long id){
        return complaintFormService.findById(id);
    }

}
