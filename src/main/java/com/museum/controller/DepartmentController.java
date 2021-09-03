package com.museum.controller;

import com.museum.domain.Account;
import com.museum.service.IAccountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IDepartmentService;
import com.museum.domain.Department;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-06-04
 */
@Api(tags = {"通用功能-----部门组件"})
@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",maxAge = 3600)
public class DepartmentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IDepartmentService departmentService;

    @Resource
    private IAccountService accountService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Department department){
        return departmentService.add(department);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return departmentService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Department department){
        return departmentService.updateData(department);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Department> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return departmentService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Department findById(@PathVariable Long id){
        return departmentService.findById(id);
    }

    @ApiOperation(value = "获取当前登录用户的部门")
    @PostMapping("/getDepartment")
    public Department getDepartment(HttpServletRequest req){
        Account ac=accountService.findAccount(req);
        Department de=departmentService.findById(Long.valueOf(ac.getId()));
        return de;
    }

    @ApiOperation(value = "返回所有部门")
    @PostMapping("/getListDepartment")
    public List<Department> getListDepartment(HttpServletRequest req){
        return departmentService.list();
    }

}
