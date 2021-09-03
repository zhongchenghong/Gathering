package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.Resources;
import com.museum.service.IAccountService;
import com.museum.util.HttpContextUtil;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IImmovableDataService;
import com.museum.domain.ImmovableData;
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
 * 数据中心-不可移动文物数据 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-23
 */
@Api(tags = {"数据中心-不可移动文物数据"})
@RestController
@RequestMapping("/immovable-data")
public class ImmovableDataController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IImmovableDataService immovableDataService;

    //文件地址
    @Value("${File}")
    private String File;

    @Resource
    private IAccountService accountService;


    @ApiOperation(value = "新增数据中心-不可移动文物数据")
    @PostMapping("/add")
    public Result add(String depement, String name, String filename, String fileaddress, MultipartFile file, HttpServletRequest req){
        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            File fileSave = new File(File, newVidoeName);
            file.transferTo(fileSave);
            QueryWrapper queryWrapper  = new QueryWrapper();
            queryWrapper.eq("userName",name);
            //获取用户名
            Account acc=accountService.findAccount(req);
            ImmovableData immovableData = new ImmovableData();
            immovableData.setUid(acc.getId());
            immovableData.setCreatetimes(SystemDateUtils.getStrDate());
            immovableData.setDepement(depement);
            immovableData.setName(name);
            immovableData.setFileaddress(fileSave.getCanonicalPath());
            immovableData.setFilename(file.getOriginalFilename());
            //存文件内容
            immovableDataService.add(immovableData);
            return   ResultUtil.success();

        }catch (Exception e){
            e.printStackTrace();
            return  ResultUtil.error(500,"上传失败");

        }
    }

    @ApiOperation(value = "删除数据中心-不可移动文物数据")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return immovableDataService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-不可移动文物数据")
    @PutMapping()
    public int update(@RequestBody ImmovableData immovableData){
        return immovableDataService.updateData(immovableData);
    }

    @ApiOperation(value = "查询数据中心-不可移动文物数据分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/bypage")
    public IPage<ImmovableData> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String filename){
        QueryWrapper queryWrapper  = new QueryWrapper();
        if(filename!=null&&!"".equals(filename)){
            queryWrapper.like("filename",filename);
        }

        return immovableDataService.page(immovableDataService.findListByPage(page, pageCount),queryWrapper);
    }




    @ApiOperation(value = "id查询数据中心-不可移动文物数据")
    @GetMapping("{id}")
    public ImmovableData findById(@PathVariable Long id){
        return immovableDataService.findById(id);
    }

}
