package com.po;

public class Student {
    private Integer Id;
    private String manger;
    private String name;
    private Float pay;
    private String remark;

    public Student() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getManager() {
        return manger;
    }

    public void setManager(String manger) {
        this.manger = manger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPay() {
        return pay;
    }

    public void setPay(Float pay) {
        this.pay = pay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", manager='" + manger + '\'' +
                ", name='" + name + '\'' +
                ", pay=" + pay +
                ", remark='" + remark + '\'' +
                '}';
    }
}

