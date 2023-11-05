package com.example.practiceapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(
        name = "product"
)
public class Products {
    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Column(name = "pname")
    private String pname;

    @Column(name = "pdesc")
    private String pdesc;

    @ManyToOne
    @JoinColumn(name = "cid", nullable = false)
    @JsonIgnore
    private Categories categories;

    @Column(name = "pstatus")
    private Integer pstatus;

    public Products() {
    }

    public Products(String pname, String pdesc, Categories categories, Integer pstatus) {
        this.pname = pname;
        this.pdesc = pdesc;
        this.categories = categories;
        this.pstatus = pstatus;
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

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Integer getPstatus() {
        return pstatus;
    }

    public void setPstatus(Integer pstatus) {
        this.pstatus = pstatus;
    }

    @Override
    public String toString() {
        return "product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", categories=" + categories +
                ", pstatus=" + pstatus +
                '}';
    }
}
