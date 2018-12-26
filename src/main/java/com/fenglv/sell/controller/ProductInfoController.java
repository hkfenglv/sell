package com.fenglv.sell.controller;

import com.fenglv.sell.entity.ProductCategory;
import com.fenglv.sell.entity.ProductInfo;
import com.fenglv.sell.service.ProductCategoryService;
import com.fenglv.sell.service.ProductInfoService;
import com.fenglv.sell.util.CollectionUtil;
import com.fenglv.sell.util.ResultVoUtil;
import com.fenglv.sell.vo.ProductInfoVo;
import com.fenglv.sell.vo.ProductVo;
import com.fenglv.sell.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

//http://127.0.0.1:8080/sell/buyer/product/list
@RestController
@RequestMapping("/buyer/product")
public class ProductInfoController {

    @Resource
    private ProductInfoService productInfoService;
    @Resource
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVo list(){
        List<ProductInfo> active = productInfoService.findActive();
        if(CollectionUtil.isEmpty(active)){
            return ResultVoUtil.error("未查询到有效商品");
        }
        Set<Integer> categorySet = new HashSet<>();
        for(ProductInfo e:active){
            categorySet.add(e.getCategoryType());
        }
        List<ProductCategory> categoryTypeList = productCategoryService.getListByCategoryTypeList(new ArrayList<>(categorySet));
        if(CollectionUtil.isEmpty(categoryTypeList)){
            return ResultVoUtil.error("未查询到有效商品");
        }
        List<ProductVo> resultVo = new ArrayList<>();
        for (ProductCategory category:categoryTypeList){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(category.getCategoryName());
            productVo.setCategoryType(category.getCategoryType());
            List<ProductInfoVo> infoVoList = new ArrayList<>();
            for(ProductInfo info:active){
                if(info.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(info,productInfoVo);
                    infoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(infoVoList);
            resultVo.add(productVo);
        }
        return ResultVoUtil.success(resultVo);
    }
}
