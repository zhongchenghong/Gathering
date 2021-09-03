package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.domain.Account;
import com.museum.domain.SendDocument;
import com.museum.service.IAccountService;
import com.museum.service.ISendDocumentService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * <p>
 * 办公室公文管理-发文 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Api(tags = {"办公室公---文管理-收文统计"})
@RestController
@RequestMapping("/receip-document")
public class ReceiptDocumentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ISendDocumentService sendDocumentService;

    @Resource
    private IAccountService accountService;



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
/*
    @ApiOperation(value = "id查询办公室公文管理-发文")
    @GetMapping("{id}")
    public SendDocument findById(@PathVariable Long id){
        return sendDocumentService.findById(id);
    }


    @ApiOperation(value = "收文按月统计")
    @GetMapping("{id}")
    public SendDocument findById(@PathVariable Long id){
        return sendDocumentService.findById(id);
    }*/

}
