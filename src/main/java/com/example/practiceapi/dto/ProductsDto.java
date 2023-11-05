package com.example.practiceapi.dto;

public class ProductsDto {
    private Integer pid;
    private String pname;
    private String pdesc;
//    private CategoriesDto categories;

    public ProductsDto() {
    }

    public ProductsDto(Integer pid, String pname, String pdesc, CategoriesDto categories) {
        this.pid = pid;
        this.pname = pname;
        this.pdesc = pdesc;
//        this.categories = categories;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

//    public CategoriesDto getCategories() {
//        return categories;
//    }
//
//    public void setCategories(CategoriesDto categories) {
//        this.categories = categories;
//    }

    @Override
    public String toString() {
        return "ProductsDto{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pdesc='" + pdesc + '\'' +
//                ", categories=" + categories +
                '}';
    }
}
