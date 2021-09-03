package com.museum.util.page;


/**
 *
 * 描述：分页接口
 *
 * 作者： LevelCoder
 *
 * 日期：2016年12月13日 下午1:49:01
 *
 * 版本： 1.0
 */
public interface IPageList<Entity> {
    /**
     * 计算总记录数
     *
     * @return
     */
    public int getItemCount();

    /**
     * 获取当前页码
     * @return
     */
    public int getPageIndex();

    /**
     * 每页显示的记录数量
     *
     * @return
     */
    public int getPageSize();

    /**
     * 计算总页数.
     *
     * @return
     */
    public int getPageCount();

    /**
     * 获取是否有上一页
     * @return
     */
    public boolean getHasPre();

    /**
     * 获取是否有下一页
     * @return
     */
    public boolean getHasNext();

    public String resolveUrl(String url, String queryString, Integer pageNo, Integer pageSize);
}