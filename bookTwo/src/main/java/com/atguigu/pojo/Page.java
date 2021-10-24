package com.atguigu.pojo;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE = 4 ;

    private Integer pageNo ;
    private Integer pageTotal ;
    private Integer page_Size = PAGE_SIZE ;
    private Integer pageCount ;
    private List<T> items ;
    private String url ;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer page_Size, Integer pagenCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.page_Size = page_Size;
        this.pageCount = pagenCount;
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if(pageNo < 1){
            pageNo = 1;
         }else if(pageNo > pageTotal){
            pageNo = pageTotal ;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPage_Size() {
        return page_Size;
    }

    public void setPage_Size(Integer page_Size) {
        this.page_Size = page_Size;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pagenCount) {
        this.pageCount = pagenCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", page_Size=" + page_Size +
                ", pageCount=" + pageCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
