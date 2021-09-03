package com.museum.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.museum.domain.AccountList;
import com.museum.domain.MailList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lsj
 * @since 2021-07-01
 */
public interface AccountListMapper extends  BaseMapper<AccountList>{
     @Select("  select\n" +
             "            account.id,account.userName,department.department_name as departmentName,\n" +
             "            position.position_name as positionName,account.phone,account.fixed_line as fixedLine,account_mail_list.mail_list_name as mailListName,account.email\n" +
             "            from mail_list\n" +
             "            LEFT JOIN account on mail_list.mail_uid=account.id\n" +
             "            LEFT JOIN account_mail_list on mail_list.mail_list_id=account_mail_list.id\n" +
             "            LEFT JOIN position on account.position_id=position.id\n" +
             "            LEFT JOIN department on account.department_id=department.id\n" +
             "            where account_mail_list.id=#{id} and mail_list.uid=#{uid} GROUP BY mail_list.id")
    List<AccountList> accountList(@Param("id") int id, @Param("uid") int uid);


    @Select({"<script>" +
            "select \n" +
            "account.userName,\n" +
            "department.department_name as departmentName,\n" +
            "position.position_name as positionName,\n" +
            "account.phone,\n" +
            "account.fixed_line as fixedLine,\n" +
            "account_mail_list.mail_list_name as mailListName,\n" +
            "account.email from account \n" +
            "LEFT JOIN mail_list on mail_list.mail_uid = account.id\n" +
            "LEFT JOIN account_mail_list on mail_list.mail_list_id = account_mail_list.id \n" +
            "LEFT JOIN position on account.position_id=position.id\n" +
            "LEFT JOIN department on account.department_id=department.id\n" +
            "LEFT JOIN (select uid,mail_list_name FROM account_mail_list \n" +
            "where account_mail_list.uid=1) as am on am.uid=account.id where 1=1 \n" +
            "<when test=\"userName != null\">\n" +
            "   AND account.userName LIKE  CONCAT(\"%\",#{userName},\"%\") \n" +
            "</when>\n" +
            "GROUP BY account.id\n"+
            "</script>"})
    List<AccountList> accounttotalList(@Param("userName") String userName,@Param("uid") int uid);

}
