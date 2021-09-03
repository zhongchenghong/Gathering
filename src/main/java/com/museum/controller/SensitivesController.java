package com.museum.controller;

import com.museum.common.sensitive.SensitiveWordInit;
import com.museum.common.sensitive.SensitivewordEngine;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ISensitivesService;
import com.museum.domain.Sensitives;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-06-08
 */
@Api(tags = {"敏感字"})
@RestController
@RequestMapping("/sensitives")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class SensitivesController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ISensitivesService sensitivesService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Sensitives sensitives) {
        Date daDate = SystemDateUtils.getDaDate();
        sensitives.setTimes(daDate);
        return sensitivesService.add(sensitives);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id) {
        return sensitivesService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Sensitives sensitives) {
        return sensitivesService.updateData(sensitives);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Sensitives> findListByPage(@RequestParam Integer page,
                                            @RequestParam Integer pageCount) {
        return sensitivesService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Sensitives findById(@PathVariable Long id) {
        return sensitivesService.findById(id);
    }


    @ApiOperation(value = "id查询")
    @GetMapping("/getlist")
    public List<String> findList(String str) {
        // 初始化敏感词库对象
        SensitiveWordInit sensitiveWordInit = new SensitiveWordInit();
        // 从数据库中获取敏感词对象集合（调用的方法来自Dao层，此方法是service层的实现类）
        List<Sensitives> sensitiveWords = sensitivesService.list();
        // 构建敏感词库
        Map sensitiveWordMap = sensitiveWordInit.initKeyWord(sensitiveWords);
        // 传入SensitivewordEngine类中的敏感词库
        SensitivewordEngine.sensitiveWordMap = sensitiveWordMap;
        // 得到敏感词有哪些，传入2表示获取所有敏感词
        List<String> set = SensitivewordEngine.getSensitiveWord(str, 2);
        return set;

    }



}