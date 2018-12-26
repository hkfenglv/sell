package com.fenglv.sell.service;

import com.fenglv.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {

    /**根据产品id获取**/
    ProductInfo findOne(String productId);

    /**获取所有活动商品**/
    List<ProductInfo> findActive();

    /**分页获取所有商品**/
    Page<ProductInfo> findAll(Pageable pageable);

    /**保存**/
    ProductInfo save(ProductInfo productInfo);

    /**库存的改变**/

}
