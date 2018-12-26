package com.fenglv.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;
    /**商品名称.*/
    private String productName;
    /**商品单价.*/
    private BigDecimal productPrice;
    /**商品库存.*/
    private Integer productStock;
    /**商品描述.*/
    private String productDescription;
    /**商品小图.*/
    private String productIcon;
    /**商品类型.*/
    private Integer categoryType;
    /**商品状态 0-未上架，1-已上架.*/
    private Integer productStatus;

}
