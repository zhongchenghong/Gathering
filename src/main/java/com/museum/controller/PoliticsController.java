package com.museum.controller;

import com.museum.common.politics.PoliticsWordInit;
import com.museum.common.politics.PoliticswordEngine;
import com.museum.common.sensitive.SensitiveWordInit;
import com.museum.common.sensitive.SensitivewordEngine;
import com.museum.domain.Sensitives;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IPoliticsService;
import com.museum.domain.Politics;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-06-08
 */
@Api(tags = {"政治术语编辑"})
@RestController
@RequestMapping("/politics")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class PoliticsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPoliticsService politicsService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Politics politics){
        return politicsService.add(politics);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return politicsService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Politics politics){
        return politicsService.updateData(politics);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Politics> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return politicsService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Politics findById(@PathVariable Long id){
        return politicsService.findById(id);
    }

    @ApiOperation(value = "测试")
    @GetMapping("/getlist")
    public List<String> findList(String str) {
        // 初始化政治术语库对象
        PoliticsWordInit politicsWordInit = new PoliticsWordInit();
        // 从数据库中获取政治术语对象集合（调用的方法来自Dao层，此方法是service层的实现类）
        List<Politics> politics = politicsService.list();
        // 构建敏感词库
        Map sensitiveWordMap = politicsWordInit.initKeyWord(politics);
        // 传入SensitivewordEngine类中的政治术语
        PoliticswordEngine.sensitiveWordMap = sensitiveWordMap;
        // 得到敏感词有哪些，传入2表示获取所有政治术语
        List<String> set = PoliticswordEngine.getSensitiveWord(str, 2);
        return set;

    }

}
