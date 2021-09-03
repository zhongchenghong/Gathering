package com.museum.controller;

import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ITrademarkService;
import com.museum.domain.Trademark;
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
 * 文创产业部商标添加 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Api(tags = {"文创产业部商标添加"})
@RestController
@RequestMapping("/trademark")
public class TrademarkController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ITrademarkService trademarkService;

    @Resource
    private IAccountService accountService;


    @ApiOperation(value = "新增文创产业部商标添加")
    @PostMapping()
    public int add(@RequestBody Trademark trademark, HttpServletRequest req){
        Account acc=accountService.findAccount(req);
        trademark.setUid(acc.getId());
        trademark.setCreatetimes(SystemDateUtils.getStrDate());
        return trademarkService.add(trademark);
    }

    @ApiOperation(value = "删除文创产业部商标添加")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return trademarkService.delete(id);
    }

    @ApiOperation(value = "更新文创产业部商标添加")
    @PutMapping()
    public int update(@RequestBody Trademark trademark){
        return trademarkService.updateData(trademark);
    }

    @ApiOperation(value = "查询文创产业部商标添加分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Trademark> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return trademarkService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询文创产业部商标添加")
    @GetMapping("{id}")
    public Trademark findById(@PathVariable Long id){
        return trademarkService.findById(id);
    }

}
