package com.museum.controller;

import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IPositionService;
import com.museum.domain.Position;
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
 * @since 2021-06-08
 */
@Api(tags = {"组织"})
@RestController
@RequestMapping("/position")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class PositionController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPositionService positionService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Position position){
        String str=SystemDateUtils.getStrDate();
        position.setCreatetime(str);
        return positionService.add(position);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return positionService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Position position){
        return positionService.updateData(position);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Position> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return positionService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Position findById(@PathVariable Long id){
        return positionService.findById(id);
    }

}
