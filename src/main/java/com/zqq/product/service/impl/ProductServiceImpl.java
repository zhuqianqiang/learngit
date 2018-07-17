package com.zqq.product.service.impl;

import com.zqq.product.dataobject.ProductCategory;
import com.zqq.product.dataobject.ProductInfo;
import com.zqq.product.enums.ProductStatusEnum;
import com.zqq.product.repository.ProductCategoryRepository;
import com.zqq.product.repository.ProductInfoRepository;
import com.zqq.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> list = productInfoRepository.findByProductStatus(ProductStatusEnum.up.getCode());
        return list;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void test() throws Exception {
        insertCategory1();
        insertProductInfo();

        throw new Exception();

    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public ProductInfo insertProductInfo(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("25");
        productInfo.setProductName("qq");
        productInfo.setProductPrice(new BigDecimal(123));
        productInfo.setProductStock(1);
        productInfo.setCategoryType(1);
        return productInfoRepository.save(productInfo);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void insertCategory1() {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("555");
        productCategoryRepository.save(category);

    }
}
