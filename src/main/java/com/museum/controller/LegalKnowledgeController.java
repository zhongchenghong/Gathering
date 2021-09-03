package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.Result;
import com.museum.common.ResultUtil;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ILegalKnowledgeService;
import com.museum.domain.LegalKnowledge;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-07-08
 */
@Api(tags = {"知识库开发"})
@RestController
@RequestMapping("/legal-knowledge")
public class LegalKnowledgeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ILegalKnowledgeService legalKnowledgeService;

    @Resource
    private IAccountService accountService;

    //文件地址
    @Value("${File}")
    private String File;


    @ApiOperation(value = "新增")
    @PostMapping()
    public Result add(HttpServletRequest req, int lawType, String lawTitle, String lawContent, MultipartFile file){
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=accountService.getOne(queryWrapper);
        File fileSave=null;
        //保存文件
        LegalKnowledge legalKnowledge = new LegalKnowledge();
        if(file!=null){
            //获取文件后缀
            try {
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            fileSave = new File(File, newVidoeName);
            FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
            legalKnowledge.setFilename(file.getOriginalFilename());
            legalKnowledge.setLawFilepath(fileSave.getCanonicalPath());

            }catch (Exception e){
                return  ResultUtil.error(401,"发生为止错误");
            }

        }
            legalKnowledge.setLawTitle(lawTitle);
            legalKnowledge.setLawContent(lawContent);
            legalKnowledge.setLawType(lawType);
            String date=SystemDateUtils.getStrDate();
            legalKnowledge.setCreatetimes(date);
            legalKnowledge.setUid(bo.getId());
            legalKnowledgeService.add(legalKnowledge);
            return ResultUtil.success("上传成功");

    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return legalKnowledgeService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody LegalKnowledge legalKnowledge){
        return legalKnowledgeService.updateData(legalKnowledge);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<LegalKnowledge> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String title){
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.like("law_title",title);
        return legalKnowledgeService.page(legalKnowledgeService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public LegalKnowledge findById(@PathVariable Long id){
        return legalKnowledgeService.findById(id);
    }

}
