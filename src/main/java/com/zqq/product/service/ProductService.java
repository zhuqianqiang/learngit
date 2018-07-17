package com.zqq.product.service;

import com.zqq.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findUpAll() ;

    ProductInfo insertProductInfo() throws Exception;

    void insertCategory1() throws Exception;

    void test() throws Exception;
}
