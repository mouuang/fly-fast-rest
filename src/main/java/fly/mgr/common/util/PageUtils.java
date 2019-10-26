package fly.mgr.common.util;

import java.util.List;

/**
 * 分页工具
 * @Date 2019年10月15日
 */
public class PageUtils {

    /** 总记录数  */
    private int totalCount;
    
    /** 每页记录数  */
    private int pageSize;
    
    /** 当前页 */
    private int currPage;
    
    /** 总页数 */
    private int totalPage;
    
    /** 列表数据 */
    private List<?> list;
    
    
    /**
     * 分页
     * @param list              列表数据
     * @param totalCount        总记录数
     * @param pageSize          每页记录数
     * @param currPage          当前页
     */
    public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
    }


    public int getTotalCount() {
        return totalCount;
    }


    public int getPageSize() {
        return pageSize;
    }


    public int getCurrPage() {
        return currPage;
    }


    public int getTotalPage() {
        return totalPage;
    }


    public List<?> getList() {
        return list;
    }
    
}
