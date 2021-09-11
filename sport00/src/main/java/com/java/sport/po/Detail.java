package com.java.sport.po;

import java.io.Serializable;
import lombok.Data;

/**
 * bbs_detail
 * @author 
 */
@Data
public class Detail implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 商品编号
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     *  颜色名称
     */
    private String color;

    /**
     * 尺码
     */
    private String size;

    /**
     * 商品销售价
     */
    private Double price;

    /**
     * 购买数量
     */
    private Integer amount;

    private static final long serialVersionUID = 1L;
}