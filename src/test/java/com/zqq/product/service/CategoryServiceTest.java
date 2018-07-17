package com.zqq.product.service;

import com.zqq.product.ProductApplication;
import com.zqq.product.ProductApplicationTests;
import com.zqq.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@Component
public class CategoryServiceTest extends ProductApplicationTests{

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(1,2));
        Assert.assertTrue(list.size()>0);
    }
}