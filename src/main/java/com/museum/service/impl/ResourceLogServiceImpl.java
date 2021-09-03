package com.museum.service.impl;

import com.museum.domain.Account;
import com.museum.domain.Department;
import com.museum.domain.Position;
import com.museum.domain.ResourceLog;
import com.museum.dao.ResourceLogMapper;
import com.museum.service.IResourceLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-06-18
 */
@Service
public class ResourceLogServiceImpl extends ServiceImpl<ResourceLogMapper, ResourceLog> implements IResourceLogService {

    @Override
    public  IPage<ResourceLog> findListByPage(Integer page, Integer pageCount){
        IPage<ResourceLog> wherePage = new Page<>(page, pageCount);
        ResourceLog where = new ResourceLog();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(ResourceLog resourceLog){
        return baseMapper.insert(resourceLog);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(ResourceLog resourceLog){
        return baseMapper.updateById(resourceLog);
    }

    @Override
    public ResourceLog findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public HSSFWorkbook createContractExcel(List<ResourceLog> list) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("资源操作日志列表");
        // 新增数据行，并且设置单元格数据
        int rowNum = 1;
        // headers表示excel表中第一行的表头 在excel表中添加表头
        String[] headers = { "操作人姓名", "操作时间", "操作类型", "ip地址","操作类型"};
        HSSFRow row = sheet.createRow(0);
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //在表中存放查询到的数据放入对应的列
        for (ResourceLog item : list) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(item.getUsername());
            row1.createCell(1).setCellValue(item.getCreateDate());
            row1.createCell(2).setCellValue(item.getOperation());
            row1.createCell(3).setCellValue(item.getIp());
            row1.createCell(4).setCellValue(item.getOperation());
            rowNum++;
        }
        return workbook;
    }
}
