package com.zqq.product.service.impl;

import com.zqq.product.dataobject.ProductCategory;
import com.zqq.product.repository.ProductCategoryRepository;
import com.zqq.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> list) {
        return productCategoryRepository.findByCategoryTypeIn(list);
    }

    @Override
    public void save1() {
        ProductCategory category = new ProductCategory();
        productCategoryRepository.save(category);
    }
}
