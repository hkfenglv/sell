package com.fenglv.sell.service.impl;

import com.fenglv.sell.dao.ProductCategoryDao;
import com.fenglv.sell.entity.ProductCategory;
import com.fenglv.sell.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Resource
    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findOne(Integer id) {
        return productCategoryDao.findById(id).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> getListByCategoryTypeList(List<Integer> list) {
        return productCategoryDao.getListByCategoryTypeIn(list);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
