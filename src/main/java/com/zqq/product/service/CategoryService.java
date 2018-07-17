package com.zqq.product.service;

import com.zqq.product.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);

    public void save1();
}
