package com.fenglv.sell.service;

import com.fenglv.sell.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory findOne(Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> getListByCategoryTypeList(List<Integer> list);

    ProductCategory save(ProductCategory productCategory);
}
