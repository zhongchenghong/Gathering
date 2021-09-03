package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.domain.Resources;
import com.museum.service.IAccountService;
import com.museum.util.HttpContextUtil;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IAdditionProductService;
import com.museum.domain.AdditionProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 文创产业部-新增产品 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-20
 */
@Api(tags = {"文创产业部-新增产品"})
@RestController
@RequestMapping("/addition-product")
public class AdditionProductController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAdditionProductService additionProductService;

    @Resource
    private IAccountService accountService;

    @Value("${picture}")
    private String picture;

    @ApiOperation(value = "新增文创产业部-新增产品")
    @PostMapping()
    public Result add(String name, String price, String sum, Date uptime, String introduction, HttpServletRequest req, MultipartFile file){

        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存文件
            File fileSave = new File(picture, newVidoeName);
            file.transferTo(fileSave);
            Account acc=accountService.findAccount(req);
            AdditionProduct additionProduct  = new AdditionProduct();
            additionProduct.setName(name);
            additionProduct.setPrice(price);
            additionProduct.setSum(sum);
            additionProduct.setUptime(uptime);
            additionProduct.setIntroduction(introduction);
            additionProduct.setCreatetimes(SystemDateUtils.getStrDate());
            additionProduct.setUid(acc.getId());
            additionProduct.setFileaddress(fileSave.getCanonicalPath());
            additionProduct.setFilename(file.getOriginalFilename());
            additionProductService.add(additionProduct);
            //存文件内容
            return   ResultUtil.success();

        }catch (Exception e){
            e.printStackTrace();
            return  ResultUtil.error(500,"上传失败");

        }

    }

    @ApiOperation(value = "删除文创产业部-新增产品")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return additionProductService.delete(id);
    }

    @ApiOperation(value = "更新文创产业部-新增产品")
    @PutMapping()
    public int update(@RequestBody AdditionProduct additionProduct){
        return additionProductService.updateData(additionProduct);
    }

    @ApiOperation(value = "查询文创产业部-新增产品分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<AdditionProduct> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return additionProductService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询文创产业部-新增产品")
    @GetMapping("{id}")
    public AdditionProduct findById(@PathVariable Long id){
        return additionProductService.findById(id);
    }

}
