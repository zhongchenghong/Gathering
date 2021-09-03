package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IDataCollectionProcessService;
import com.museum.domain.DataCollectionProcess;
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
 * @since 2021-07-20
 */
@Api(tags = {"影像资料制作流程"})
@RestController
@RequestMapping("/data-collection-process")
public class DataCollectionProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IDataCollectionProcessService dataCollectionProcessService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody DataCollectionProcess dataCollectionProcess){
        return dataCollectionProcessService.add(dataCollectionProcess);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return dataCollectionProcessService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody DataCollectionProcess dataCollectionProcess){
        return dataCollectionProcessService.updateData(dataCollectionProcess);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<DataCollectionProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return dataCollectionProcessService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public DataCollectionProcess findById(@PathVariable Long id){
        return dataCollectionProcessService.findById(id);
    }

}
