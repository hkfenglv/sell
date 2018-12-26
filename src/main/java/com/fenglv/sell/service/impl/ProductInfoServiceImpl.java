package com.fenglv.sell.service.impl;

import com.fenglv.sell.constants.ProductInfoConstants;
import com.fenglv.sell.dao.ProductInfoDao;
import com.fenglv.sell.entity.ProductInfo;
import com.fenglv.sell.service.ProductInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Resource
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findActive() {
        return productInfoDao.findByProductStatus(ProductInfoConstants.ACTIVE.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }
}
