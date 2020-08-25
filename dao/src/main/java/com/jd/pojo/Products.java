package com.jd.pojo;

public class Products {
    private Integer pid;
    private Integer cid;
    private String pname;
    private Double price;

    public Products(){}

    public Products(Integer pid, Integer cid, String pname, Double price) {
        this.pid = pid;
        this.cid = cid;
        this.pname = pname;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Products{" +
                "pid=" + pid +
                ", cid=" + cid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                '}';
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
