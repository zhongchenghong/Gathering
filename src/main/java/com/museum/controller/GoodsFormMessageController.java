package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IGoodsFormMessageService;
import com.museum.domain.GoodsFormMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Api(tags = {"信息中心"})
@RestController
@RequestMapping("/goods-form-message")
public class GoodsFormMessageController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IGoodsFormMessageService goodsFormMessageService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody GoodsFormMessage goodsFormMessage){
        return goodsFormMessageService.add(goodsFormMessage);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return goodsFormMessageService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody GoodsFormMessage goodsFormMessage){
        return goodsFormMessageService.updateData(goodsFormMessage);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<GoodsFormMessage> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return goodsFormMessageService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public GoodsFormMessage findById(@PathVariable Long id){
        return goodsFormMessageService.findById(id);
    }

}
