package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ICarFormService;
import com.museum.domain.CarForm;
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
 * @since 2021-07-21
 */
@Api(tags = {"办公室驾----用车申请表单"})
@RestController
@RequestMapping("/car-form")
public class CarFormController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICarFormService carFormService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody CarForm carForm){
        return carFormService.add(carForm);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return carFormService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody CarForm carForm){
        return carFormService.updateData(carForm);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<CarForm> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return carFormService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public CarForm findById(@PathVariable Long id){
        return carFormService.findById(id);
    }

}
