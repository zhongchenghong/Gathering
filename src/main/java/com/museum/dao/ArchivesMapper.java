package com.museum.dao;

import com.museum.domain.ArchiveBydepartment;
import com.museum.domain.Archives;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lsj
 * @since 2021-07-15
 */
public interface ArchivesMapper extends BaseMapper<Archives> {
    @Select("select COUNT(id) as count ,archives.department as department  from archives GROUP BY archives.departmentId")
    List<ArchiveBydepartment> selectArchiveBydepartment();

    @Select("select COUNT(archives.id) as total, COUNT(archives.archivesTypeId) as count ,archives.archivesTypeId as department  from archives where createTime %${createTime}% GROUP BY archives.archivesTypeId")
    List<ArchiveBydepartment> selectarchivesTypeId(String createTime);

}
