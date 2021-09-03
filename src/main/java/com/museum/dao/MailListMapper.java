package com.museum.dao;

import com.museum.domain.AccountList;
import com.museum.domain.MailList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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
public interface MailListMapper extends BaseMapper<MailList> {

    List<AccountList> accountList(@Param("id") int id, @Param("uid") int uid);

}
