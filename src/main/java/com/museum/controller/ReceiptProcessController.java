package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IReceiptProcessService;
import com.museum.domain.ReceiptProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 办公室--收文 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-24
 */
@Api(tags = {"办公室--收文"})
@RestController
@RequestMapping("/receipt-process")
public class ReceiptProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IReceiptProcessService receiptProcessService;


    @ApiOperation(value = "新增办公室--收文")
    @PostMapping()
    public int add(@RequestBody ReceiptProcess receiptProcess){
        return receiptProcessService.add(receiptProcess);
    }

    @ApiOperation(value = "删除办公室--收文")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return receiptProcessService.delete(id);
    }

    @ApiOperation(value = "更新办公室--收文")
    @PutMapping()
    public int update(@RequestBody ReceiptProcess receiptProcess){
        return receiptProcessService.updateData(receiptProcess);
    }

    @ApiOperation(value = "查询办公室--收文分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ReceiptProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return receiptProcessService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询办公室--收文")
    @GetMapping("{id}")
    public ReceiptProcess findById(@PathVariable Long id){
        return receiptProcessService.findById(id);
    }

}
