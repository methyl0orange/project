package com.java.sport.po;

import lombok.Data;

import java.io.Serializable;

/**
 * bbs_brand
 * @author 
 */
@Data
public class Brand implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 图片Url
     */
    private String imgUrl;

    /**
     * 品牌网址
     */
    private String webSite;

    /**
     * 排序:最大最排前
     */
    private Integer sort;

    /**
     * 是否可见 1:可见 0:不可见
     */
    private Boolean isDisplay;

    private static final long serialVersionUID = 1L;
}