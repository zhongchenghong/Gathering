package com.museum.controller;

import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ITrainRegisterService;
import com.museum.domain.TrainRegister;
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
 * 锦里培训登记 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-06
 */
@Api(tags = {"锦里----锦里培训登记"})
@RestController
@RequestMapping("/train-register")
public class TrainRegisterController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ITrainRegisterService trainRegisterService;


    @Resource
    private IAccountService accountService;

    //文件地址
    @Value("${File}")
    private String File;


    @ApiOperation(value = "新增锦里培训登记")
    @PostMapping()
    public int add(TrainRegister trainRegister, HttpServletRequest req, MultipartFile file){
        String str= SystemDateUtils.getStrDate();
        Account ac=accountService.findAccount(req);
        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            File fileSave = new File(File, newVidoeName);
            FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
            trainRegister.setFileaddress(fileSave.getCanonicalPath());
            trainRegister.setFilename(file.getOriginalFilename());
            trainRegister.setCreatetime(str);
            trainRegister.setUid(ac.getId());

        }catch (Exception e){
            e.printStackTrace();

        }

        return trainRegisterService.add(trainRegister);
    }

    @ApiOperation(value = "删除锦里培训登记")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return trainRegisterService.delete(id);
    }

    @ApiOperation(value = "更新锦里培训登记")
    @PutMapping()
    public int update(@RequestBody TrainRegister trainRegister){
        return trainRegisterService.updateData(trainRegister);
    }

    @ApiOperation(value = "查询锦里培训登记分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<TrainRegister> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return trainRegisterService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询锦里培训登记详情")
    @GetMapping("{id}")
    public TrainRegister findById(@PathVariable Long id){
        return trainRegisterService.findById(id);
    }

}
