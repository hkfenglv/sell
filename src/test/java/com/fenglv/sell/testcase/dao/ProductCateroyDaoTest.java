package com.fenglv.sell.testcase.dao;

import com.fenglv.sell.dao.ProductCategoryDao;
import com.fenglv.sell.entity.ProductCategory;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Data
public class ProductCateroyDaoTest {
    @Resource
    private ProductCategoryDao productCategoryDao;
    @Test
    @Transactional
    public void testInsert(){
        ProductCategory entity = new ProductCategory();
        entity.setCategoryName("成人用品2号");
        entity.setCategoryType(6);
        ProductCategory save = productCategoryDao.save(entity);
        Assert.assertNotNull(save);
    }

    @Test
    public void testUpdate(){
        Optional<ProductCategory> entity = productCategoryDao.findById(3);
        ProductCategory category = entity.get();
        category.setCategoryType(1155);
        productCategoryDao.save(category);

        //productCategoryDao.save(entity);
    }



    @Test
    public void testFind(){
        Optional<ProductCategory> byId = productCategoryDao.findById(3);
        System.out.println(byId);
    }

    @Test
    public void getListByCategoryTypeIdTest(){
        List<Integer> list =Arrays.asList(2,3,5);
        List<ProductCategory> categoryList = productCategoryDao.getListByCategoryTypeIn(list);
        Assert.assertNotEquals(0, categoryList.size());

    }
}
