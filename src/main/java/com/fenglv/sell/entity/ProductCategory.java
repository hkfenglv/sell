package com.fenglv.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @DynamicUpdate 注解是为了动态更新时间
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory{

    /**类目编号.*/
    @Id
    @GeneratedValue
    private  Integer categoryId;
    /**类目名称.*/
    private String categoryName;
    /**类目类型.*/
    private  Integer categoryType;

}
