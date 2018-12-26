package com.fenglv.sell.service.impl;

import com.fenglv.sell.entity.ProductInfo;
import com.fenglv.sell.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    @Resource
    private ProductInfoService productInfoService;

    @Test
    public void findOne() {
        ProductInfo result = productInfoService.findOne("31321");
        assertNotNull(result);
    }

    @Test
    public void findActive() {
        List<ProductInfo> list = productInfoService.findActive();
        assertNotEquals(0,list.size());
    }

    @Test
    public void findAll() {
        PageRequest page = PageRequest.of(1,20);
        Page<ProductInfo> pageResult = productInfoService.findAll(page);
        Iterator<ProductInfo> iterator = pageResult.iterator();
        System.out.println("开始打印结果");
        while (iterator.hasNext()){
            ProductInfo info = iterator.next();
            System.out.println(info);
        }
        assertNotEquals(0,pageResult.getSize());
    }

    @Test
    public void save() {
        ProductInfo info = new ProductInfo();
        info.setProductId("31322");
        info.setProductName("烤全羊");
        info.setProductPrice(new BigDecimal(2915.5));
        info.setProductDescription("聚餐必备");
        info.setProductIcon("http://xxxx.com");
        info.setProductStock(30);
        info.setProductStatus(1);
        info.setCategoryType(4);
        ProductInfo result = productInfoService.save(info);
        assertNotNull(result);
    }
}