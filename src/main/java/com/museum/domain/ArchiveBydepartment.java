package com.museum.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="档案按部门统计", description="")
public class ArchiveBydepartment {
    private String department;
    private Integer count;
    private String  percentage;
    private Integer  total;
}
