package com.museum.util.page;

import java.util.List;

/**
 *
 * 描述：分页工具类
 *
 * 作者： LevelCoder
 *
 * 日期：2016年12月13日 下午1:49:21
 *
 * 版本： 1.0
 */
public class PageListUtil {
    /**
     * 默认的起始页
     */
    public static final int DEFAULT_PAGE_NO=1;

    /**
     * 默认的分页显示数量
     */
    public static final int DEFAULT_PAGE_SIZE=20;

    public static final String PAGE_NO_NAME="pageNo";

    public static final String PAGE_SIZE_NAME="pageSize";

    /**
     * 不关心总记录数
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public static int getPageListStart(int pageNumber, int pageSize) {
        return (pageNumber - 1) * pageSize;
    }

    /**
     * 计算分页获取数据时游标的起始位置
     * @param totalCount
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public static int getPageListStart(int totalCount, int pageNumber, int pageSize) {
        int start = (pageNumber - 1) * pageSize;
        if (start >= totalCount)
            start = 0;

        return start;
    }

    /**
     * 构造分页对象
     * @param totalCount
     * @param pageIndex
     * @param items
     * @param pageSize
     * @return
     */
    public static <Entity> PageList<Entity> getPageList(int totalCount, int pageIndex, List<Entity> items, int pageSize) {
        return new PageList<Entity>(totalCount, pageIndex, pageSize, items);
    }
}