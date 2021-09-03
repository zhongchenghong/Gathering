package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.service.IArchivesService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IGardenPlantsService;
import com.museum.domain.GardenPlants;
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
 * 园林景观-新增植物 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-12
 */
@Api(tags = {"园林景观-新增植物"})
@RestController
@RequestMapping("/garden-plants")
public class GardenPlantsController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IGardenPlantsService gardenPlantsService;

    @Resource
    private IAccountService accountService;




    @ApiOperation(value = "新增园林景观-新增植物")
    @PostMapping()
    public int add(@RequestBody GardenPlants gardenPlants, HttpServletRequest req){
        Account ac=accountService.findAccount(req);
        gardenPlants.setUid(ac.getId());
        gardenPlants.setCreatetime(SystemDateUtils.getStrDate());
        return gardenPlantsService.add(gardenPlants);
    }

    @ApiOperation(value = "删除园林景观-新增植物")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return gardenPlantsService.delete(id);
    }

    @ApiOperation(value = "更新园林景观-新增植物")
    @PutMapping()
    public int update(@RequestBody GardenPlants gardenPlants){
        return gardenPlantsService.updateData(gardenPlants);
    }

    @ApiOperation(value = "查询园林景观-新增植物分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<GardenPlants> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String name,String diameter,String section,String genus,String nickname){

        QueryWrapper queryWrapper = new QueryWrapper();
        if(name!=null&&!"".equals(name)){
            queryWrapper.eq("name", name);
        }

        if(diameter!=null&&!"".equals(diameter)){
            queryWrapper.eq("diameter", diameter);
        }

        if(section!=null&&!"".equals(section)){
            queryWrapper.eq("section", section);
        }

        if(genus!=null&&!"".equals(genus)){
            queryWrapper.eq("genus", genus);
        }

        if(nickname!=null&&!"".equals(nickname)){
            queryWrapper.eq("nickname", nickname);
        }


        return gardenPlantsService.page(gardenPlantsService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询园林景观-新增植物")
    @GetMapping("{id}")
    public GardenPlants findById(@PathVariable Long id){
        return gardenPlantsService.findById(id);
    }

}
