package com.java.sport.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * bbs_sku
 * @author 
 */
@Data
public class Sku implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 颜色ID
     */
    private Long colorId;

    /**
     * 尺码
     */
    private String size;

    /**
     * 市场价
     */
    private Double marketPrice;

    /**
     * 售价
     */
    private Double price;

    /**
     * 运费 默认10元
     */
    private Double deliveFee;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 购买限制
     */
    private Integer upperLimit;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}