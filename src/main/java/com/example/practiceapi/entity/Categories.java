package com.example.practiceapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(
        name = "categories"
)
public class Categories {
    @Id
    @Column(name = "cid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Column(name = "cname")
    private String cname;

    @Column(name = "cdesc")
    private String cdesc;

    @Column(name = "cstatus")
    private Integer cstatus;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Products> products;

    public Categories() {
    }

    public Categories(Integer cid, String cname, String cdesc, Integer cstatus, Collection<Products> products) {
        this.cid = cid;
        this.cname = cname;
        this.cdesc = cdesc;
        this.cstatus = cstatus;
        this.products = products;
    }

    public Collection<Products> getProducts() {
        return products;
    }

    public void setProducts(Collection<Products> products) {
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
        return "categories{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdesc='" + cdesc + '\'' +
                ", cstatus=" + cstatus +
                ", products=" + products +
                '}';
    }
}
