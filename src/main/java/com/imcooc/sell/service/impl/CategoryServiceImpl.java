package com.imcooc.sell.service.impl;

import com.imcooc.sell.dataObject.ProductCategory;
import com.imcooc.sell.repository.ProductCategoryRepository;
import com.imcooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
    private   ProductCategoryRepository   repository;


    @Override
    public ProductCategory findOne(Integer categoryId) {
        return  repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }
}
