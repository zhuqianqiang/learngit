package com.zqq.product.controller;

import com.zqq.product.VO.ProductInfoVO;
import com.zqq.product.VO.ProductVO;
import com.zqq.product.VO.ResultVO;
import com.zqq.product.dataobject.ProductCategory;
import com.zqq.product.dataobject.ProductInfo;
import com.zqq.product.service.CategoryService;
import com.zqq.product.service.ProductService;
import com.zqq.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询在架的商品
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory:categoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
