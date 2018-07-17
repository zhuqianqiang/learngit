package com.zqq.product.repository;

import com.zqq.product.dataobject.ProductCategory;
import com.zqq.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

        List<ProductInfo> findByProductStatus(Integer productStatus);

        ProductInfo save(ProductInfo productInfo);
}
