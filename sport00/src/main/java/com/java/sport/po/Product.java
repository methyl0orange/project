package com.java.sport.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * bbs_product
 * @author 
 */
@Data
public class Product implements Serializable {
    /**
     * ID或商品编号
     */
    private Long id;

    /**
     * 品牌ID
     */
    private Integer brandId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 重量 单位:克
     */
    private Double weight;

    /**
     * 是否新品:0:旧品,1:新品
     */
    private Boolean isNew;

    /**
     * 是否热销:0,否 1:是
     */
    private Boolean isHot;

    /**
     * 推荐 1推荐 0 不推荐
     */
    private Boolean isCommend;

    /**
     * 上下架:0否 1是
     */
    private Boolean isShow;

    /**
     * 商品图片集
     */
    private String imgUrl;

    /**
     * 是否删除:0删除,1,没删除
     */
    private Boolean isDel;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 包装清单
     */
    private String packageList;

    /**
     * 颜色集
     */
    private String colors;

    /**
     * 尺寸集
     */
    private String sizes;

    /**
     * 添加时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}