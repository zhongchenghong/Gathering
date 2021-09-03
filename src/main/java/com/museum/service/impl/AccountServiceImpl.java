package com.museum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.common.shiro.JWTUtil;
import com.museum.domain.Account;
import com.museum.dao.AccountMapper;
import com.museum.domain.Department;
import com.museum.domain.Position;
import com.museum.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.museum.service.IDepartmentService;
import com.museum.service.IPositionService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsj
 * @since 2021-05-25
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
    @Autowired
    IDepartmentService departmentService;

    @Autowired
    IPositionService positionService;

    @Override
    public  IPage<Account> findListByPage(Integer page, Integer pageCount){
        IPage<Account> wherePage = new Page<>(page, pageCount);
        Account where = new Account();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Account account){
        return baseMapper.insert(account);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Account account){
        return baseMapper.updateById(account);
    }

    @Override
    public Account findById(Long id){
        return  baseMapper.selectById(id);
    }

    public Account  getAccount(HttpServletRequest req) {
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=getOne(queryWrapper);
        return bo;
    }

    public HSSFWorkbook createContractExcel(List<Account> account){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("账户列表");
        // 新增数据行，并且设置单元格数据
        int rowNum = 1;
        // headers表示excel表中第一行的表头 在excel表中添加表头
        String[] headers = { "账号", "手机号", "部门", "职位","邮箱"};
        HSSFRow row = sheet.createRow(0);
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //在表中存放查询到的数据放入对应的列
        for (Account item : account) {
            HSSFRow row1 = sheet.createRow(rowNum);
            if(item.getDepartmentId()!=null&&!"".equals(item.getDepartmentId())){
                Department de =departmentService.findById(Long.valueOf(item.getDepartmentId()));
                row1.createCell(2).setCellValue(de.getDepartmentName());
            }
            if(item.getPositionId()!=null&&!"".equals(item.getPositionId())){
               Position po= positionService.findById(Long.valueOf(item.getPositionId()));
                row1.createCell(3).setCellValue(po.getPositionName());
            }
            row1.createCell(0).setCellValue(item.getUserName());
            row1.createCell(1).setCellValue(item.getPhone());
            row1.createCell(4).setCellValue(item.getEmail());
            rowNum++;
        }
        return workbook;
    }

    public Account findAccount(HttpServletRequest req){
        String token=req.getHeader("token");
        String name= JWTUtil.getUsername(token);
        QueryWrapper queryWrapper  = new QueryWrapper();
        queryWrapper.eq("userName",name);
        Account bo=getOne(queryWrapper);
        return bo;
    }
}
