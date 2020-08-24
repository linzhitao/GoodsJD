package com.jd.bean;

public class Products {
    private Integer pid;
    private Integer cid;
    private String pname;
    private Double price;
    private int size;



    public Products(){

    }

    public Products(Integer pid, Integer cid, String pname, Double price) {
        this.pid = pid;
        this.cid = cid;
        this.pname = pname;
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
