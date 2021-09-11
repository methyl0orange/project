package com.java.sport.po;

import java.io.Serializable;
import lombok.Data;

/**
 * bbs_color
 * @author 
 */
@Data
public class Color implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父ID为色系
     */
    private Long parentId;

    /**
     * 颜色对应的衣服小图
     */
    private String imgUrl;

    private static final long serialVersionUID = 1L;
}