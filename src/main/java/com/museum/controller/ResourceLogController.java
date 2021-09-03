package com.museum.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IResourceLogService;
import com.museum.domain.ResourceLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-06-18
 */
@Api(tags = {"资源日志"})
@RestController
@RequestMapping("/resource-log")
public class ResourceLogController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IResourceLogService resourceLogService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody ResourceLog resourceLog){
        return resourceLogService.add(resourceLog);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public void delete(List<Integer> li) {
        resourceLogService.removeByIds(li);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody ResourceLog resourceLog){
        return resourceLogService.updateData(resourceLog);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ResourceLog> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return resourceLogService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public ResourceLog findById(@PathVariable Long id){
        return resourceLogService.findById(id);
    }

    @ApiOperation(value = "导出操作日志")
    @GetMapping("/exportExcle")
    public void exportExcle(HttpServletResponse response){
        List<ResourceLog> list=resourceLogService.list();
        HSSFWorkbook workbook = resourceLogService.createContractExcel(list);
        // 设置要导出的文件的名字
        String fileName = "资源上传日志"  + new Date() + ".xls";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
