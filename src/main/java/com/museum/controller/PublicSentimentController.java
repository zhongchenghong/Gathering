package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IPublicSentimentService;
import com.museum.domain.PublicSentiment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据中心-舆情 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-30
 */
@Api(tags = {"数据中心-舆情"})
@RestController
@RequestMapping("/public-sentiment")
public class PublicSentimentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPublicSentimentService publicSentimentService;


    @ApiOperation(value = "新增数据中心-舆情")
    @PostMapping()
    public int add(@RequestBody PublicSentiment publicSentiment){
        return publicSentimentService.add(publicSentiment);
    }

    @ApiOperation(value = "删除数据中心-舆情")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return publicSentimentService.delete(id);
    }

    @ApiOperation(value = "更新数据中心-舆情")
    @PutMapping()
    public int update(@RequestBody PublicSentiment publicSentiment){
        return publicSentimentService.updateData(publicSentiment);
    }

    @ApiOperation(value = "查询数据中心-舆情分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<PublicSentiment> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return publicSentimentService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询数据中心-舆情")
    @GetMapping("{id}")
    public PublicSentiment findById(@PathVariable Long id){
        return publicSentimentService.findById(id);
    }

}
