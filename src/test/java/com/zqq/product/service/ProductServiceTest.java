package com.zqq.product.service;

import com.zqq.product.ProductApplicationTests;
import com.zqq.product.dataobject.ProductInfo;
import org.apache.commons.math.stat.descriptive.summary.Product;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;
@Component
public class ProductServiceTest extends ProductApplicationTests{

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void test() throws Exception {
        productService.test();
    }

}