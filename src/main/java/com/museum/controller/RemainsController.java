package com.museum.controller;

import com.museum.common.Log.MyLog;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.domain.AcademicPapers;
import com.museum.domain.Account;
import com.museum.domain.Resources;
import com.museum.service.IAccountService;
import com.museum.util.FileUtil;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IRemainsService;
import com.museum.domain.Remains;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 * 数据中心-遗存调查数据 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Api(tags = {"数据中心-遗存调查数据"})
@RestController
@RequestMapping("/remains")
public class RemainsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRemainsService remainsService;

    @Resource
    private IAccountService accountService;

    @Value("${File}")
    private String File;


    @ApiOperation(value = "新增数据中心-遗存调查数据")
    @PostMapping()
    public Result add(String address, String content, String line, HttpServletRequest req, MultipartFile file){
        Account acc = accountService.findAccount(req);
        Remains remains = new Remains();
        remains.setAddress(address);
        remains.setContent(content);
        remains.setLine(line);
        remains.setUid(acc.getId());
        remains.setCreatetimes(SystemDateUtils.getStrDate());

        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            java.io.File fileSave = new File(File, newVidoeName);
            file.transferTo(fileSave);
            //获取用户名
            remains.setFileaddress(fileSave.getCanonicalPath());
            remains.setFilename(file.getOriginalFilename());
            remainsService.add(remains);
            return   ResultUtil.success();

        }catch (Exception e){
            e.printStackTrace();
            return  ResultUtil.error(500,"上传失败");

        }

    }

    @ApiOperation(value = "删除数据中心-遗存调查数据")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return remainsService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-遗存调查数据")
    @PutMapping()
    public int update(@RequestBody Remains remains){
        return remainsService.updateData(remains);
    }

    @ApiOperation(value = "查询数据中心-遗存调查数据分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Remains> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return remainsService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询数据中心-遗存调查数据")
    @GetMapping("{id}")
    public Remains findById(@PathVariable Long id){
        return remainsService.findById(id);
    }

    @ApiOperation(value = "下载文件")
    @GetMapping("/down")
    @MyLog(value = "下载文件")
    public void down(@PathVariable Long id, HttpServletResponse res){
        System.out.println(id);
        Remains re = remainsService.findById(id);
        Resources ress = new Resources();
        ress.setPathaddress(re.getFileaddress());
        ress.setFilename(re.getFilename());
        try {
            FileUtil.downloadpath(re.getFilename(),res,ress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
