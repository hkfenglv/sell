package com.fenglv.sell.dao;

import com.fenglv.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Resource
    private ProductInfoDao productInfoDao;

    @Test
    public  void testSave(){
        ProductInfo info = new ProductInfo();
        info.setProductId("31321");
        info.setProductName("黄焖鸡");
        info.setProductPrice(new BigDecimal(15.5));
        info.setProductDescription("天下一绝，安陆汽车站首选！");
        info.setProductIcon("http://xxxx.com");
        info.setProductStock(30);
        info.setProductStatus(1);
        info.setCategoryType(4);
        ProductInfo result = productInfoDao.save(info);
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetProductListByStatus(){
        List<ProductInfo> result = productInfoDao.findByProductStatus(1);
        Assert.assertNotEquals(0,result.size());
    }
}