package com.example.practiceapi.dto;

import java.util.List;

public class CategoriesDto {
    private Integer cid;
    private String cname;
    private String cdesc;
    private Integer cstatus;
    private List<ProductsDto> products;


    public CategoriesDto() {
    }

    public CategoriesDto(Integer cid, String cname, String cdesc, Integer cstatus, List<ProductsDto> products) {
        this.cid = cid;
        this.cname = cname;
        this.cdesc = cdesc;
        this.cstatus = cstatus;
        this.products = products;
    }

    public List<ProductsDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsDto> products) {
        this.products = products;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    public Integer getCstatus() {
        return cstatus;
    }

    public void setCstatus(Integer cstatus) {
        this.cstatus = cstatus;
    }

    @Override
    public String toString() {
        return "CategoriesDto{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdesc='" + cdesc + '\'' +
                ", cstatus=" + cstatus +
                ", products=" + products +
                '}';
    }
}
