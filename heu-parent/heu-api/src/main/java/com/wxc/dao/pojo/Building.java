package com.wxc.dao.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Building {
    @NotNull
    private Integer buildingnum;

    private  String location;

    private  String buildingurl;
}
