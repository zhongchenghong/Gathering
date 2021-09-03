package com.museum.controller;

import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IScreenService;
import com.museum.domain.Screen;
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
 * @since 2021-06-29
 */
@Api(tags = {"统一发布------编辑、添加大屏分辨率、位置、名称"})
@RestController
@RequestMapping("/screen")
public class ScreenController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IScreenService screenService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Screen screen){
        String str=SystemDateUtils.getStrDate();
        screen.setCreatetimes(str);
        return screenService.add(screen);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return screenService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Screen screen){
        return screenService.updateData(screen);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Screen> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return screenService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Screen findById(@PathVariable Long id){

        return screenService.findById(id);
    }

    @ApiOperation(value = "")
    @PutMapping("/putscreen")
    public int updatePage(@RequestBody Screen screen){
        return screenService.updateData(screen);
    }

}
