package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.museum.domain.Syslog;
import com.museum.service.ISyslogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-12
 */
@Api(tags = {"操作日志管理"})
@RestController
@RequestMapping("/systemLog")
public class SyslogController {

    @Resource
    private ISyslogService syslogService;

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping("/log")
    public IPage<Syslog> findListByPage(@RequestParam Integer page,
                                        @RequestParam Integer pageCount,String name, String operation,
                                        String startTime, String endTime) {
        QueryWrapper queryWrapper  = new QueryWrapper();
        if(name!=null&&!"".equals(name)){
            queryWrapper.like("username",name);
        }
        if(operation!=null&&!"".equals(operation)){
            queryWrapper.eq("operation",operation);
        }

        if(startTime!=null&&!"".equals(startTime)){
            queryWrapper.between("createDate",startTime,endTime);
        }



        return syslogService.page(syslogService.findListByPage(page, pageCount),queryWrapper);
    }

    @GetMapping("/deleteLog")
    @ApiOperation(value = "删除操作记录")
    public void  deleteLog(List<Integer> li) {
        syslogService.removeByIds(li);
    }
}
