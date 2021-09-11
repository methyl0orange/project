package com.oracle.po;

import java.io.Serializable;
import lombok.Data;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Integer id;

    private String manger;

    private String name;

    private Double pay;

    private String remark;

    private static final long serialVersionUID = 1L;
}