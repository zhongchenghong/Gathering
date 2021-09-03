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
import com.museum.service.ISendDocumentService;
import com.museum.domain.SendDocument;
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
 * 办公室公文管理-发文 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Api(tags = {"办公室公文管理---发文"})
@RestController
@RequestMapping("/send-document")
public class SendDocumentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ISendDocumentService sendDocumentService;

    @Resource
    private IAccountService accountService;

    //文件地址
    @Value("${File}")
    private String File;


    @ApiOperation(value = "新增办公室公文管理-发文")
    @PostMapping("/add")
    public Result add(String document, String document1, String degree, String releaseTime,
                      String briefing, String stage, String mainCopy, String viceCopy, String depoment, String name, String apppltTime, String title
                    , String remoke, String filename, String fileaddress, Integer uid, HttpServletRequest req, MultipartFile file){
            Account acc=accountService.findAccount(req);
            SendDocument sd = new SendDocument();
            sd.setDepoment(document);
            sd.setDocument1(document1);
            sd.setDegree(degree);
            sd.setReleaseTime(releaseTime);
            sd.setBriefing(briefing);
            sd.setStage(stage);
            sd.setMainCopy(mainCopy);
            sd.setViceCopy(viceCopy);
            sd.setDepoment(depoment);
            sd.setApppltTime(apppltTime);
            sd.setTitle(title);
            sd.setRemoke(remoke);
            sd.setName(name);
            sd.setUid(uid);

        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            File fileSave = new File(File, newVidoeName);
            file.transferTo(fileSave);
            sd.setFilename(file.getOriginalFilename());
            sd.setFileaddress(fileSave.getCanonicalPath());
            sd.setCreatetimes(SystemDateUtils.getStrDate());
            sendDocumentService.add(sd);
            //存文件内容
            return   ResultUtil.success();

        }catch (Exception e){
            e.printStackTrace();
            return  ResultUtil.error(500,"上传失败");

        }

    }

    @ApiOperation(value = "删除办公室公文管理-发文")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return sendDocumentService.delete(id);
    }

    @ApiOperation(value = "更新办公室公文管理-发文")
    @PutMapping()
    public int update(@RequestBody SendDocument sendDocument){
        return sendDocumentService.updateData(sendDocument);
    }

    @ApiOperation(value = "查询办公室公文管理-发文分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<SendDocument> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String title){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("title", title);
        return sendDocumentService.page(sendDocumentService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询办公室公文管理-发文")
    @GetMapping("{id}")
    public SendDocument findById(@PathVariable Long id){
        return sendDocumentService.findById(id);
    }

}
