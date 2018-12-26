package com.fenglv.sell.service.impl;

import com.fenglv.sell.entity.ProductCategory;
import com.fenglv.sell.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Resource
    private ProductCategoryService productCategoryService;

    @Test
    public void findOne() {
        ProductCategory one = productCategoryService.findOne(1);
        Assert.assertEquals(new Integer(1),one.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> all = productCategoryService.findAll();
        Assert.assertNotNull(all);
    }

    @Test
    public void getListByCategoryTypeList() {
        List<ProductCategory> list = productCategoryService.getListByCategoryTypeList(Arrays.asList(2, 3, 4, 5));
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(67);
        productCategory.setCategoryName("测试");
        ProductCategory save = productCategoryService.save(productCategory);
        Assert.assertNotNull(save);
    }
}