package com.museum.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 活动录入按年统计
 * </p>
 *
 * @author lsj
 * @since 2021-08-03
 */
@Data
public class ActivityEntryCountByYear {

    private Integer count;

    private String year;

    private String exhibitionfathertypename;
}
