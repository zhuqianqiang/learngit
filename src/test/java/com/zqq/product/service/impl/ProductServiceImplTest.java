package com.zqq.product.service.impl;

import com.zqq.product.ProductApplicationTests;
import com.zqq.product.dataobject.ProductInfo;
import com.zqq.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;
@Component
public class ProductServiceImplTest extends ProductApplicationTests{

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }
}