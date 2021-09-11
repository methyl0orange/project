package com.oracle.po;

public class s {
    private String SNo;
    private String SN;
    private String Sex;
    private Integer Age;
    private String Dept;

    public s() {
        super();
    }

    public String getSNo() {
        return SNo;
    }

    public void setSNo(String SNo) {
        this.SNo = SNo;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    @Override
    public String toString() {
        return "s{" +
                "SNo='" + SNo + '\'' +
                ", SN='" + SN + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Age=" + Age +
                ", Dept='" + Dept + '\'' +
                '}';
    }

}
