package com.oracle.po;

import java.util.Date;

public class Car {
    private Integer carid;

    private String name;

    private Date birthday;

    private String pailiang;

    private String leixing;

    private Integer renshu;

    private Integer jixiang;

    private Integer price;

    private String imgurl;

    private String state;

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPailiang() {
        return pailiang;
    }

    public void setPailiang(String pailiang) {
        this.pailiang = pailiang == null ? null : pailiang.trim();
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing == null ? null : leixing.trim();
    }

    public Integer getRenshu() {
        return renshu;
    }

    public void setRenshu(Integer renshu) {
        this.renshu = renshu;
    }

    public Integer getJixiang() {
        return jixiang;
    }

    public void setJixiang(Integer jixiang) {
        this.jixiang = jixiang;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", pailiang='" + pailiang + '\'' +
                ", leixing='" + leixing + '\'' +
                ", renshu=" + renshu +
                ", jixiang=" + jixiang +
                ", price=" + price +
                ", imgurl='" + imgurl + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}