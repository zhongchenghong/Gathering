package com.museum.controller;

import com.museum.util.SearchRequest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.museum.service.IResourceContentService;
import com.museum.domain.ResourceContent;
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
 * @since 2021-06-18
 */
@Api(tags = {"全文检索"})
@RestController
@RequestMapping("/resource-content")
public class ResourceContentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IResourceContentService resourceContentService;



    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody ResourceContent resourceContent){
        return resourceContentService.add(resourceContent);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return resourceContentService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody ResourceContent resourceContent){
        return resourceContentService.updateData(resourceContent);
    }

    @ApiOperation(value = "全文检索")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ResourceContent> findListByPage(@RequestParam Integer page,
                                                 @RequestParam Integer pageCount, SearchRequest request){
      /*  //创建查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //结果过滤
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{"cid", "name"}, null));
        //分页
        queryBuilder.withPageable(PageRequest.of(page, pageCount));
        //过滤
        queryBuilder.withQuery(QueryBuilders.matchQuery("name", request.getKey()));
        //查询
        AggregatedPage<ResourceContent> result = template.queryForPage(queryBuilder.build(), ResourceContent.class);
*/        return resourceContentService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public ResourceContent findById(@PathVariable Long id){
        return resourceContentService.findById(id);
    }

}
