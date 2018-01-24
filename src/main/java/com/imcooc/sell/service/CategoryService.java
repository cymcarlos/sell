package com.imcooc.sell.service;

import com.imcooc.sell.dataObject.ProductCategory;

import java.util.List;

public interface CategoryService {


     ProductCategory   findOne(Integer  categoryId);

     List<ProductCategory>  findAll();

     ProductCategory save(ProductCategory  productCategory);

     List<ProductCategory> findByCategoryTypeIn(List<Integer>   categoryTypeList);
}
