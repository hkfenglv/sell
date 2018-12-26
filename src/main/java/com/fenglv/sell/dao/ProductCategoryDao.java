package com.fenglv.sell.dao;

import com.fenglv.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> getListByCategoryTypeIn(List<Integer> list);
}
