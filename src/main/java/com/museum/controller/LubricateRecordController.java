package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ILubricateRecordService;
import com.museum.domain.LubricateRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 办公室加油登记 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Api(tags = {"办公室加油登记"})
@RestController
@RequestMapping("/lubricate-record")
public class LubricateRecordController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ILubricateRecordService lubricateRecordService;

    @Resource
    private IAccountService accountService;

    @ApiOperation(value = "新增办公室加油登记")
    @PostMapping()
    public int add(@RequestBody LubricateRecord lubricateRecord, HttpServletRequest req){
        Account acc=accountService.findAccount(req);
        lubricateRecord.setUid(acc.getId());
        lubricateRecord.setCreatetimes(SystemDateUtils.getStrDate());
        return lubricateRecordService.add(lubricateRecord);
    }

    @ApiOperation(value = "删除办公室加油登记")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return lubricateRecordService.delete(id);
    }

    @ApiOperation(value = "更新办公室加油登记")
    @PutMapping()
    public int update(@RequestBody LubricateRecord lubricateRecord){
        return lubricateRecordService.updateData(lubricateRecord);
    }

    @ApiOperation(value = "查询办公室加油登记分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<LubricateRecord> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String cards){
        QueryWrapper queryWrapper  = new QueryWrapper();

        if(cards!=null&&!"".equals(cards)){
            queryWrapper.like("cards",cards);
        }
        return lubricateRecordService.page(lubricateRecordService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询办公室加油登记")
    @GetMapping("{id}")
    public LubricateRecord findById(@PathVariable Long id){
        return lubricateRecordService.findById(id);
    }

}
