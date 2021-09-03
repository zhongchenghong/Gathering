package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IParkingProcessService;
import com.museum.domain.ParkingProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 临时停车申请流程 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-23
 */
@Api(tags = {"临时停车申请流程"})
@RestController
@RequestMapping("/parking-process")
public class ParkingProcessController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IParkingProcessService parkingProcessService;


    @ApiOperation(value = "新增临时停车申请流程")
    @PostMapping()
    public int add(@RequestBody ParkingProcess parkingProcess){
        return parkingProcessService.add(parkingProcess);
    }

    @ApiOperation(value = "删除临时停车申请流程")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return parkingProcessService.delete(id);
    }

    @ApiOperation(value = "更新临时停车申请流程")
    @PutMapping()
    public int update(@RequestBody ParkingProcess parkingProcess){
        return parkingProcessService.updateData(parkingProcess);
    }

    @ApiOperation(value = "查询临时停车申请流程分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ParkingProcess> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return parkingProcessService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询临时停车申请流程")
    @GetMapping("{id}")
    public ParkingProcess findById(@PathVariable Long id){
        return parkingProcessService.findById(id);
    }

}
