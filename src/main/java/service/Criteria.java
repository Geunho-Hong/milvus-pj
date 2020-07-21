package service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {

    private int page;
    private int perPageNum;
    private String type;
    private String keyword;

    public Criteria(){
        this.page = 1;
        this.perPageNum = 10;
    }

    public Criteria(int page, int perPageNum) {
        this.page = page;
        this.perPageNum = perPageNum;
    }

    public void setPage(int page) {
        if(page <=0) {
            this.page = 1;
        }else{
            this.page = page;
        }
    }

    public void setPerPageNum(int pageCount) {
        int cnt = this.perPageNum;
        if(pageCount != cnt) {
            this.perPageNum = cnt;
        }else {
            this.perPageNum = pageCount;
        }
    }

    public int getPage() {
        return page;
    }

    public int getPageStart() {
        return (this.page -1 ) * perPageNum;
    }

    public int getPerPageNum() {
        return this.perPageNum;
    }

    @Override
    public String toString() {
        return "Criteria [page =" + page + ", " + "perPageNum= "+ perPageNum +"]";
    }

}