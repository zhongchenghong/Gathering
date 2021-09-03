package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IRoleService;
import com.museum.domain.Role;
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
 * @since 2021-06-07
 */
@Api(tags = {"用户角色"})
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class RoleController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRoleService roleService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Role role){
        return roleService.add(role);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return roleService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Role role){
        return roleService.updateData(role);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Role> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return roleService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Role findById(@PathVariable Long id){
        return roleService.findById(id);
    }

}
